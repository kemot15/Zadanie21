package pl.javastart.zad.model;

public enum Category {
    SPOZYWCZE ("Art. spożywcze"),
    DOMOWE ("Art. gosp. domowego"),
    INNE ("Inne");

    private String categoryName;

    private Category(String categoryName) {
        this.categoryName = categoryName;

    }

    public String getCategoryName() {
        return categoryName;
    }
}
