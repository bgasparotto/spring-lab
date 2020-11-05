# Spring Lab

## Beans

### Bean Scopes

- **Singleton**: (default) `@Scope("singleton")`, single instance for each Spring container and bean
  id;
- **Prototype**: `@Scope("prototype")` - creates a new instance every time the bean is requested.
  Unlike other scopes, destruction callback methods are not called by Spring on prototype beans, as
  they are created by the Spring container and handed to the application, which is then responsible
  for any needed cleanups.
- **Request** (web-aware): `@RequestScope` - creates a new instance for each HTTP request;
- **Session** (web-aware): `@SessionScope` - creates a new instance for each HTTP session;
- **Application** (web-aware): `@ApplicationScope` - creates a single instance for each
  *ServletContext* (not for each *ApplicationContext* as the singleton bean scope);
- **WebSocket**
  (web-aware): `@Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)` - creates
  a new instance for each *WebSocket* session.

### Bean lifecycle

#### Lifecycle callback