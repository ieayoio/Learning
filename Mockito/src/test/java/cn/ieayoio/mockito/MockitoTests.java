package cn.ieayoio.mockito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by ieayoio on 2017/5/11.
 */

@RunWith(MockitoJUnitRunner.class)
public class MockitoTests {

    @Test
    public void verify_behaviour() {
        //模拟创建一个List对象
        List mock = mock(List.class);
        //使用mock的对象
        mock.add(1);
        mock.clear();
        //验证add(1)和clear()行为是否发生
        verify(mock).add(1);
        verify(mock).clear();
    }

    @Test
    public void when_thenReturn() {
        //mock一个Iterator类
        Iterator iterator = mock(Iterator.class);
        //预设当iterator调用next()时第一次返回hello，第n次都返回world
        when(iterator.next()).thenReturn("hello").thenReturn("world");
        //使用mock的对象
        String result = iterator.next() + " " + iterator.next() + " " + iterator.next();

        System.out.println(result);
        //验证结果
        Assert.assertEquals("hello world world", result);
    }

    @Test(expected = IOException.class)
    public void when_thenThrow() throws IOException {
        OutputStream outputStream = mock(OutputStream.class);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        //预设当流关闭时抛出异常
        doThrow(new IOException()).when(outputStream).close();
        outputStream.close();
    }

    @Test
    public void returnsSmartNullsTest() {
        List mock = mock(List.class, RETURNS_SMART_NULLS);
        System.out.println(mock.get(0));

        //使用RETURNS_SMART_NULLS参数创建的mock对象，不会抛出NullPointerException异常。另外控制台窗口会提示信息“SmartNull returned by unstubbed get() method on mock”
        System.out.println(mock.toArray().length);
    }

    @Test
    public void deepstubsTest() {
        List list = mock(List.class, RETURNS_DEEP_STUBS);
        when(list.get(0).toString()).thenReturn("ffff");
        String length = list.get(0).toString();
        System.out.println(length);
//        verify(list).get(0);
        Assert.assertEquals("ffff", list.get(0).toString());
    }

    @Test(expected = RuntimeException.class)
    public void doThrow_when() {
        List list = mock(List.class);
        doThrow(new RuntimeException()).when(list).add(1);
        list.add(1);
    }

    @Mock
    private List mockList;

    @Test
    public void shorthand() {

//        MockitoAnnotations.initMocks(this);
        // 可以直接在类上加注解@RunWith(MockitoJUnitRunner.class)

        mockList.add(1);
        verify(mockList).add(1);
    }

    @Test
    public void with_arguments() {
        Comparable comparable = mock(Comparable.class);
        //预设根据不同的参数返回不同的结果
        when(comparable.compareTo("Test")).thenReturn(1);
        when(comparable.compareTo("Omg")).thenReturn(2);
        Assert.assertEquals(1, comparable.compareTo("Test"));
        Assert.assertEquals(2, comparable.compareTo("Omg"));
        //对于没有预设的情况会返回默认值
        Assert.assertEquals(0, comparable.compareTo("Not stub"));
    }


    private class IsValid extends ArgumentMatcher<List> {
        @Override
        public boolean matches(Object o) {
            Integer integer = new Integer(o.toString());
            return integer == 1 || integer == 2;
        }
    }

    @Test
    public void with_unspecified_arguments() {
        List list = mock(List.class);
        //匹配任意参数
        when(list.get(anyInt())).thenReturn(1);
        when(list.contains(argThat(new IsValid()))).thenReturn(true);
        Assert.assertEquals(1, list.get(1));
        Assert.assertEquals(1, list.get(999));
        Assert.assertTrue(list.contains(1));
        Assert.assertTrue(!list.contains(3));
    }

    @Test
    public void all_arguments_provided_by_matchers() {
        Comparator comparator = mock(Comparator.class);
        comparator.compare("nihao", "hello");
        //如果你使用了参数匹配，那么所有的参数都必须通过matchers来匹配
//        verify(comparator).compare(anyString(),eq("hello"));
        //下面的为无效的参数匹配使用
//        verify(comparator).compare(anyString(),"hello");
    }

    class IsListofTwoElements extends ArgumentMatcher<List> {
        public boolean matches(Object list) {
            return ((List) list).size() == 2;
        }
    }

    @Test
    public void argumentMatchersTest() {
        //创建mock对象
        List<String> mock = mock(List.class);

        //argThat(Matches<T> matcher)方法用来应用自定义的规则，可以传入任何实现Matcher接口的实现类。
        when(mock.addAll(argThat(new IsListofTwoElements()))).thenReturn(true);

        mock.addAll(Arrays.asList("one", "two", "three"));
        //IsListofTwoElements用来匹配size为2的List，因为例子传入List为三个元素，所以此时将失败。
        verify(mock).addAll(argThat(new IsListofTwoElements()));
    }

    class Person {
        private int id;
        private String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    interface PersonDao {
        public void update(Person person);
    }

    class PersonService {
        private PersonDao personDao;

        PersonService(PersonDao personDao) {
            this.personDao = personDao;
        }

        public void update(int id, String name) {
            personDao.update(new Person(id, name));
        }
    }

    @Test
    public void capturing_args() {
        PersonDao personDao = mock(PersonDao.class);
        PersonService personService = new PersonService(personDao);

        ArgumentCaptor<Person> argument = ArgumentCaptor.forClass(Person.class);
//        personService.update(1, "jack");
        personService.update(2, "jack");
        verify(personDao).update(argument.capture());
        Assert.assertEquals(2, argument.getValue().getId());
        Assert.assertEquals("jack", argument.getValue().getName());
    }

    @Test
    public void answer_with_callback() {
        //使用Answer来生成我们我们期望的返回
        when(mockList.get(anyInt())).thenAnswer(new Answer<Object>() {
            //            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                return "hello world:" + args[0];
            }
        });
        Assert.assertEquals("hello world:0", mockList.get(0));
        Assert.assertEquals("hello world:999", mockList.get(999));
    }

    @Test
    public void unstubbed_invocations(){
        //mock对象使用Answer来对未预设的调用返回默认期望值
        List mock = mock(List.class,new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return 999;
            }
        });
        //下面的get(1)没有预设，通常情况下会返回NULL，但是使用了Answer改变了默认期望值
        Assert.assertEquals(999, mock.get(1));
        //下面的size()没有预设，通常情况下会返回0，但是使用了Answer改变了默认期望值
        Assert.assertEquals(999,mock.size());
    }


}
