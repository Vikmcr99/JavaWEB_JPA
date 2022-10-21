package br.edu.infnet.SpringMVC.Controller;


import br.edu.infnet.SpringMVC.Model.Domain.Student;
import br.edu.infnet.SpringMVC.Model.Repository.AlunoRepository;
import br.edu.infnet.SpringMVC.Model.service.StudentService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class StudentController {
     AlunoRepository alunoRepository = new AlunoRepository();
    
    @RequestMapping("")
    public String consulta(Model model) {
        
        model.addAttribute("lista", alunoRepository.consultarAlunos());
        return "consulta";
    }
    
    @RequestMapping("cadastro")
    public String cadastro(Model model) {
        
        Student aluno = new Student();
        model.addAttribute("aluno", aluno);
        return "cadastro";
    }
    
    @RequestMapping("cadastrar")
    public String cadastro(Model model, Student aluno) {
        
        alunoRepository.incluirAluno(aluno);
        return "redirect:/";
    }
    
    @RequestMapping("alterar")
    public ModelAndView alterar(@RequestParam int id) {
        ModelAndView mav = new ModelAndView("alterar");
        
        Student aluno = alunoRepository.consultarAluno(id);
        mav.addObject("aluno", aluno);
        return mav;
    }
    
    @RequestMapping("salvaraluno")
    public String salvarAluno(@ModelAttribute("aluno") Student aluno) {
        
        alunoRepository.alterarAluno(aluno);
        return "redirect:/";
    }
    
    @RequestMapping("excluir")
    public String excluir(@RequestParam int id) {
        
        alunoRepository.excluirAluno(id);
        return "redirect:/";
    }
//    
//    @RequestMapping("procurar")
//    public ModelAndView procurar(@RequestParam String keyword) {
//        List<Student> result = alunoService.procurarAlunos(keyword);
//        ModelAndView mav = new ModelAndView("procurar");
//        mav.addObject("result", result);
//        return mav;
//    }
}



