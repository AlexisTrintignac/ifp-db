package Domain.Dto;

public class TagsDto {
    private int id;
    private String tag;

    public TagsDto(){

    }
    public TagsDto(int id, String tag){
        this.id = id;
        this.tag = tag;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }
}
