package com.example.paymentmodule;
import com.example.paymentmodule.Payment;
import com.example.paymentmodule.data.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/payment")

public class PaymentController {
    private PaymentRepository paymentrepo;
    @Autowired
    public PaymentController(PaymentRepository paymentrepo)
    {
        this.paymentrepo=paymentrepo;
    }
    @ModelAttribute
    @GetMapping
    public String showPayment(Model model){
        model.addAttribute("payment",new Payment());
        return "payment";
    }
    @PostMapping
    public String processPayment(@Valid Payment payment, Errors errors) {
        if (errors.hasErrors()) {
            return "payment";
        }
        paymentrepo.save(payment);
        return "redirect:/";
    }

}
