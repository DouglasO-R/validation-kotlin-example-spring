package com.oliveira.validation.controller

import com.oliveira.validation.model.PersonForm
import jakarta.validation.Valid
import org.springframework.boot.context.properties.bind.BindResult
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Controller
class WebController:WebMvcConfigurer {

    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry.addViewController("/results").setViewName("results")
    }

    @GetMapping("/")
    fun showForm(personForm:PersonForm): String {
        return "form"
    }

    @PostMapping("/")
    fun checkPersonInfo(@Valid personForm: PersonForm,bindResult: BindingResult): String {
        if (bindResult.hasErrors()) {
            return "form"
        }

        return "redirect:/results"
    }
}