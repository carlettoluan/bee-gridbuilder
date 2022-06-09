package beegridbuilder.board;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import beegridbuilder.block.Bag;
import beegridbuilder.block.Block;
import beegridbuilder.block.BlockStates;
import beegridbuilder.user.User;

@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBoard;
	
	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "idUser")
	private User user;
	
	@OneToMany(mappedBy = "board",cascade = CascadeType.ALL)
	List<Bag> bags = new ArrayList<>();

	private Boolean share = Boolean.FALSE;
	
	public Board createBoard() {
		int count = 1;
		for (int countBag = 1; countBag <= 28; countBag++) {
			Bag bag = new Bag(countBag,this);
			for (int countBlock = 1; countBlock <= 24; countBlock++) {
				bag.getBlocks().add(new Block(bag,BlockStates.STAGE_0,count++));
			}
			this.getBags().add(bag);
		}
		return this;
	}

	public Long getIdBoard() {
		return idBoard;
	}

	public void setIdBoard(Long idBoard) {
		this.idBoard = idBoard;
	}	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Bag> getBags() {
		return bags;
	}

	public void setBags(List<Bag> bags) {
		this.bags = bags;
	}

	public Boolean getShare() {
		return share;
	}

	public void setShare(Boolean share) {
		this.share = share;
	}

}