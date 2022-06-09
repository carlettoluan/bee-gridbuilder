package beegridbuilder.block;

public enum BlockStates {
  
    STAGE_0("star_0.png"),STAGE_1("star_1.png"),STAGE_2("star_2.png"),STAGE_3("star_3.png");

    private String imgUrl;

    private BlockStates(String imgUrl) {
      this.imgUrl = imgUrl;
    }
    
    public String getImgUrl() {
      return imgUrl;

    }
 }
