Webflux application which uses Jetty instead of Netty.

Websockets are not working, if trying to connect to `ws://localhost:8080/ws` this log line appears

```
ERROR 57214 --- [ttp@61d01788-21] o.s.w.s.adapter.HttpWebHandlerAdapter    : [66bc796c] Error [java.lang.NullPointerException: Cannot invoke "org.eclipse.jetty.websocket.server.JettyWebSocketServerContainer.upgrade(org.eclipse.jetty.websocket.server.JettyWebSocketCreator, jakarta.servlet.http.HttpServletRequest, jakarta.servlet.http.HttpServletResponse)" because "container" is null] for HTTP GET "/ws", but ServerHttpResponse already committed (200 OK)
```

When removing the `modules` block from `build.gradle`, everything is working fine with Netty.
