package hkmu.comps380f.controller;

import hkmu.comps380f.*;
import hkmu.comps380f.op.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExampleController {

    ApplicationContext context;

    @Autowired
    public ExampleController(ApplicationContext context) {
        this.context = context;
        System.out.println("Application context " + context.toString() + " loaded.");
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    public static class CalForm {
        private long op1;
        private long op2;

        public long getOp1() {
            return op1;
        }

        public void setOp1(long op1) {
            this.op1 = op1;
        }

        public long getOp2() {
            return op2;
        }

        public void setOp2(long op2) {
            this.op2 = op2;
        }
    }

    /* Calculation Example 1 */
    @GetMapping("/calEx1")
    public ModelAndView showCalForm1() {
        return new ModelAndView("cal", "calForm", new CalForm());
    }

    @PostMapping("/calEx1")
    public ModelAndView cal1(CalForm calForm) {
        Operation ops = new OpMultiply();
        long op1 = calForm.getOp1();
        long op2 = calForm.getOp2();

        String result = "The result of " + op1
                + ops.getOpsName() + op2 + " is "
                + ops.operate(op1, op2) + "!!";
        ModelAndView mav = new ModelAndView("cal");
        mav.addObject("calForm", calForm);
        mav.addObject("result", result);
        return mav;
    }

    /* Calculation Example 2 */
    @GetMapping("/calEx2")
    public ModelAndView showCalForm2() {
        return new ModelAndView("cal", "calForm", new CalForm());
    }

    @PostMapping("/calEx2")
    public ModelAndView cal2(CalForm calForm) {
        CalculateSpring cs = (CalculateSpring) context.getBean("opsbean");
        long op1 = calForm.getOp1();
        long op2 = calForm.getOp2();

        String result = "The result of " + op1
                + cs.getOpsName() + op2 + " is "
                + cs.operate(op1, op2) + "!!";
        ModelAndView mav = new ModelAndView("cal");
        mav.addObject("calForm", calForm);
        mav.addObject("result", result);
        return mav;
    }

    /* Calculation Example 3 */
    @GetMapping("/calEx3")
    public ModelAndView showCalForm3() {
        return new ModelAndView("cal", "calForm", new CalForm());
    }

    @PostMapping("/calEx3")
    public ModelAndView cal3(CalForm calForm) {
        CalPowerSpring cs = (CalPowerSpring) context.getBean("powerOpsBean");
        long op1 = calForm.getOp1();
        long op2 = calForm.getOp2();

        String result = "The result of " + op1 + "<sup>" + cs.getPower() + "</sup>"
                + cs.getOpsName() + op2 + "<sup>" + cs.getPower() + "</sup> is "
                + cs.operate(op1, op2) + "!!";
        ModelAndView mav = new ModelAndView("cal");
        mav.addObject("calForm", calForm);
        mav.addObject("result", result);
        return mav;
    }

    /* Calculation Example 4 */
    @GetMapping("/calEx4")
    public ModelAndView showCalForm4() {
        return new ModelAndView("cal", "calForm", new CalForm());
    }

    @PostMapping("/calEx4")
    public ModelAndView cal4(CalForm calForm) {
        CalculateSpring cs = (CalculateSpring) context.getBean("opsWithInnerBean");
        long op1 = calForm.getOp1();
        long op2 = calForm.getOp2();

        String result = "The result of " + op1
                + cs.getOpsName() + op2 + " is "
                + cs.operate(op1, op2) + "!!";
        ModelAndView mav = new ModelAndView("cal");
        mav.addObject("calForm", calForm);
        mav.addObject("result", result);
        return mav;
    }

    /* List Example */
    @GetMapping("/list")
    public ModelAndView showCalFormList() {
        return new ModelAndView("cal", "calForm", new CalForm());
    }

    @PostMapping("/list")
    public ModelAndView calList(CalForm calForm) {
        CollectionSpring cs = (CollectionSpring) context.getBean("listBean");
        long op1 = calForm.getOp1();
        long op2 = calForm.getOp2();

        ModelAndView mav = new ModelAndView("cal");
        mav.addObject("calForm", calForm);
        mav.addObject("result", cs.operateResult(op1, op2));
        return mav;
    }

    /* Set Example */
    @GetMapping("/set")
    public ModelAndView showCalFormSet() {
        return new ModelAndView("cal", "calForm", new CalForm());
    }

    @PostMapping("/set")
    public ModelAndView calSet(CalForm calForm) {
        CollectionSpring cs = (CollectionSpring) context.getBean("setBean");
        long op1 = calForm.getOp1();
        long op2 = calForm.getOp2();

        ModelAndView mav = new ModelAndView("cal");
        mav.addObject("calForm", calForm);
        mav.addObject("result", cs.operateResult(op1, op2));
        return mav;
    }
}
