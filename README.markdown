## vraptor-glue
Use static methods to implement a typical app behaviour, skipping the IoC part.

This is for threadlocal static play/rails fans or those migrating a project from that scenario to a IoC one on a step-by-step basis.
Use at your own long term tight coupling risk. Unit testing also become harder. 
 
# installing

vraptor-glue.jar can be downloaded from mavens repository, or configured in any compatible tool:
```xml
	<dependency>
		<groupId>br.com.caelum.vraptor</groupId>
		<artifactId>vraptor-glue</artifactId>
		<version>please-specify-the-version-you-want</version>
	</dependency>
```

# #noextradependency

Since you are already using vraptor, there is no any extra library. Why?

We don't want you to download the internets just to solve one issue.

# Usage

By default, your controller can access any of the following components:

```
result();
use(MyView.class);
request();
response();
env();
validator();
```

If you don't want to use static imports, you can:

```
Resulter.result(); // Resulter.result returns a Result
Resulter.use(MyView.class); // shortcut to return a MyView
Http.request(); // Http.request returns a HttpServletRequest
Http.response(); // Http.request returns a HttpServletResponse
Env.env(); // Env.env returns an Environment
Validators.validator(); // Validators.validator returns a Validator
```

If you want to expose your own component, let's say `Session`, in your controller:

```
session();
```

Your interceptor:

```
import static br.com.caelum.vraptor.glue.Glue.*;

@Intercepts(before = Glueing.class)
public class SessionStatik {
	SessionStatik(Session session) {
		put(Session.class, session);
	}

	public static Session session() {
		return get(Session.class);
	}

}
```

# developers

Guilherme Silveira - creator

# collaborate and get help

- Send your pull request.
- Get help from vraptor developers and the community at guj or the vraptor mailing lists.