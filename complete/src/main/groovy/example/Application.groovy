package example

import example.micronaut.services.RegisterService
import groovy.transform.CompileStatic
import io.micronaut.runtime.Micronaut
import javax.inject.Singleton
import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.runtime.server.event.ServerStartupEvent

@CompileStatic
@Singleton
class Application implements ApplicationEventListener<ServerStartupEvent> { // <1>

    protected final RegisterService registerService

    Application(RegisterService registerService) { // <2>
        this.registerService = registerService
    }

    @Override
    void onApplicationEvent(ServerStartupEvent event) { // <1>
        registerService.register("sherlock@micronaut.example", "sherlock", 'elementary', ['ROLE_DETECTIVE']) // <3>
    }

    static void main(String[] args) {
        Micronaut.run(Application.class)
    }
}
