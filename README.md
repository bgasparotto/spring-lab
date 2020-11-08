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

A Spring bean lifecycle can be divided into creation and destruction. We can customise the execution
of these phases by implementing hook methods through annotations or interfaces.

Most commonly, this is done by the JSR-250 annotations:

- `@PostConstruct`: called after all injections have happened;
- `@PreDestroy`: called when the bean reached the end of its scope, right before destruction.

Additionally, you can hook into the bean lifecycle through:

- Providing a custom `init()` and `destroy()` implementation and setting them to be called from the
  bean definition class.
- Implementing `*Aware` interfaces;
- Implementing the `InitializingBean` and `DisposableBean` interfaces;

#### Bean Creation

1. Instantiation
2. Populate properties
3. Pre-initialisation
4. After properties set
5. Custom initialisation = `@PostConstruct`
6. Post-initialisation
7. **Bean ready**

#### Bean Destruction

1. Pre-destroy = `@PreDestroy`
2. Destroy
3. Custom destruction
4. **Bean destroyed**
