package beegridbuilder.block;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import beegridbuilder.type.Type;

@Entity
public class Block {

  public Block() {
    super();
  }

  public Block(Bag bag, BlockStates states, Integer position) {
    super();
    this.bag = bag;
    this.states = states;
    this.position = position;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idBlock;

  @ManyToOne
  @JoinColumn
  private Bag bag;

  @OneToOne
  @JoinColumn(name = "idType", referencedColumnName = "idType")
  private Type type;

  @Enumerated(EnumType.STRING)
  BlockStates states;

  private Integer position;

  private String tag;
  public Long getIdBlock() {
		return idBlock;
	}


	public void setIdBlock(Long idBlock) {
		this.idBlock = idBlock;
	}

	public Bag getBag() {
		return bag;
	}

	public void setBag(Bag bag) {
		this.bag = bag;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public BlockStates getStates() {
		return states;
	}

	public void setStates(BlockStates states) {
		this.states = states;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
}