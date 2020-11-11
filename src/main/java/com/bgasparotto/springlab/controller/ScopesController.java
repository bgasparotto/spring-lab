package com.bgasparotto.springlab.controller;

import com.bgasparotto.springlab.bean.scope.ApplicationComponent;
import com.bgasparotto.springlab.bean.scope.RequestComponent;
import com.bgasparotto.springlab.bean.scope.SessionComponent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test/scope")
public class ScopesController {
    private final RequestComponent requestComponent;
    private final SessionComponent sessionComponent;
    private final ApplicationComponent applicationComponent;

    public ScopesController(
            RequestComponent requestComponent,
            SessionComponent sessionComponent,
            ApplicationComponent applicationComponent
    ) {
        this.requestComponent = requestComponent;
        this.sessionComponent = sessionComponent;
        this.applicationComponent = applicationComponent;
    }

    @GetMapping(value = "/request")
    public String requestScope() {
        return requestComponent.getId();
    }

    @GetMapping(value = "/session")
    public String sessionScope() {
        return sessionComponent.getId();
    }

    @GetMapping(value = "/application")
    public String applicationScope() {
        return applicationComponent.getId();
    }
}
