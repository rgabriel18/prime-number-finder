package com.gabriel.challenge.sequencefinder;

import com.gabriel.challenge.sequencefinder.utils.ListUtils;
import com.gabriel.challenge.sequencefinder.utils.PrimeFinder;
import com.gabriel.challenge.sequencefinder.utils.ResourceManipulator;
import com.gabriel.challenge.sequencefinder.utils.SequenceAssembler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "assembler")
    public SequenceAssembler getAssembler() {
        return new SequenceAssembler();
    }

    @Bean(name = "primeFinder")
    public PrimeFinder getPrimeFinder() {
        return new PrimeFinder();
    }

    @Bean(name = "resourceManipulator")
    public ResourceManipulator getResourceManipulator() {
        return new ResourceManipulator();
    }

    @Bean(name = "flow")
    public Flow getFlow() {
        return new Flow();
    }

    @Bean(name = "listUtils")
    public ListUtils getListUtils() {
        return new ListUtils();
    }
}
