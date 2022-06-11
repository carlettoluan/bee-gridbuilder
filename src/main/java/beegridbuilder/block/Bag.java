package beegridbuilder.block;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import beegridbuilder.board.Board;


@Entity
public class Bag {
  
  public Bag() {
    super();
  }

  public Bag(Integer position, Board board) {
    super();

    this.position = position;
    this.board = board;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idBag;

  @ManyToOne
  @JoinColumn(name = "idBoard", referencedColumnName = "idBoard")
  private Board board;

  @OneToMany(mappedBy = "bag", cascade = CascadeType.ALL)
  List<Block> blocks = new ArrayList<>();

  private Integer position;

  public Integer posistion;

  public Integer getPosition() {
    return position;
  }
  
	public void setPosition(Integer position) {
		this.position = position;
	}

	public Long getIdBag() {
		return idBag;
	}

	public void setIdBag(Long idBag) {
		this.idBag = idBag;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public List<Block> getBlocks() {
		return blocks;
	}

	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}
}
