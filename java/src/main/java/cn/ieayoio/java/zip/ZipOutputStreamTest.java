package cn.ieayoio.java.zip;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// 压缩
public class ZipOutputStreamTest {

    public static void main(String args[]) throws IOException {
        //test1();
        test2();
    }

    public static void test1() throws IOException {
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("/Users/ieayoio/test/testzip/zip.zip"));
        //实例化一个名称为ab.txt的ZipEntry对象
        ZipEntry entry = new ZipEntry("abcc.txt");
        //设置注释
        zos.setComment("zip测试for单个文件");
        //把生成的ZipEntry对象加入到压缩文件中，而之后往压缩文件中写入的内容都会放在这个ZipEntry对象里面
        zos.putNextEntry(entry);
        InputStream is = new FileInputStream("D:\\ab.txt");
        int len = 0;
        while ((len = is.read()) != -1)
            zos.write(len);
        is.close();
        zos.close();
    }

    public static void test2() throws IOException {
        File inFile = new File("/Users/ieayoio/test/testzip/test");
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("/Users/ieayoio/test/testzip/zip.zip"));
        zos.setComment("多文件处理");
        zipFile(inFile, zos, "");
        zos.close();
    }

    public static void zipFile(File inFile, ZipOutputStream zos, String dir) throws IOException {
        if (inFile.isDirectory()) {
            File[] files = inFile.listFiles();
            for (File file:files)
                zipFile(file, zos, dir+inFile.getName() + "/"  );
        } else {
            String entryName = null;
            if (!"".equals(dir))
                entryName = dir + inFile.getName();
            else
                entryName = inFile.getName();
            ZipEntry entry = new ZipEntry(entryName);
            zos.putNextEntry(entry);
            BufferedInputStream is = new BufferedInputStream(new FileInputStream(inFile));//文件缓冲区
            byte[] datas = new byte[2048];
            int len = 0;
            while ((len = is.read(datas)) != -1)
                zos.write(datas,0,len);
            is.close();
        }

    }

}
