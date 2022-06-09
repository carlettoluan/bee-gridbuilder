package beegridbuilder.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import beegridbuilder.board.Board;
import beegridbuilder.board.BoardRepository;
import beegridbuilder.block.Block;
import beegridbuilder.block.BlockRepository;
import beegridbuilder.type.TypeRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	BlockRepository blockRepository;
	
	@Autowired
	TypeRepository typeRepository;
	
	@ModelAttribute("boards")
	public List<Board> getBoards(){
		return boardRepository.findAll();
	}
	@RequestMapping("/{id}")
	public String  home(Model model,@PathVariable("id")Long id) {
		model.addAttribute("board", boardRepository.findById(id).get());
		return "my-board";
	}
	@RequestMapping("/new")
	public String create() {
		Board board = new Board().createBoard();
		boardRepository.save(board);
		return "redirect:/"+board.getIdBoard();
		
	}
	
	@RequestMapping("/view/{id}")
	public String showModal(@PathVariable("id") Long  id,Model model) {
		model.addAttribute("knot", blockRepository.findById(id).get());
		model.addAttribute("types",typeRepository.findAll());
		return "my-board::modal-content";
	}
	
	
	@RequestMapping("/save-block")
	public String create(Block block,Long board) {
		blockRepository.save(block);
		return "redirect:/"+board;
		
	}
}
