package beegridbuilder.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.bytebuddy.description.modifier.TypeManifestation;
import beegridbuilder.board.Board;
import beegridbuilder.board.BoardRepository;
import beegridbuilder.type.Type;
import beegridbuilder.type.TypeRepository;
import beegridbuilder.util.MessageBuilder;
import beegridbuilder.util.TypeMessage;

@Controller
@RequestMapping("/type")
public class TypeController {
	@Autowired
	TypeRepository repository;
	@Autowired
	BoardRepository boardRepository;
	
	@ModelAttribute("boards")
	public List<Board> getBoards(){
		return boardRepository.findAll();
	}
	@RequestMapping()
	public String home(Model model) {
		model.addAttribute("typeList", repository.findAll());
		return "types";
	}
	@RequestMapping("/new")
	public String newType(Type type) {
		return "cad-type";
	}
	
	@RequestMapping("/edit/{id}")
	public String editType(@PathVariable(name = "id")Long id,Model model) {
		model.addAttribute("type", repository.findById(id));
		return "cad-type";
	}
	@RequestMapping("/delete/{id}")
	public String deleteType(@PathVariable(name = "id")Long id,Model model) {
		 repository.deleteById(id);
		return  "redirect:/type";
	}
	
	@RequestMapping("/save")
	public String saveType(Type type,RedirectAttributes redirectAttrs) {
		repository.save(type);
		MessageBuilder.createMsg(TypeMessage.SAVE,redirectAttrs);
		return "redirect:/type";
	}
}