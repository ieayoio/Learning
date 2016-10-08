链接：http://isilic.iteye.com/blog/1781902

HttpExchange提供了几个方法：
```
getRequestMethod()：获得请求的方法，支持GET和POST请求
getRequestHeaders()：获得请求的Headers
getRequestBody()：获得请求的输入流，输入流数据消费完的话，输入流关闭
getResponseHeaders()：出去content-length字段外，可以设置任何Response Header
sendResponseHeaders(int,long)：返回Headers
getResponseBody()：获得相应的输入流，如果响应完成，输出流必须关掉。
```
