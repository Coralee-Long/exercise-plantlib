package com.cora;

public class Plant {

    // TIP: Need to use private variables with getter/setter method:

    // Set up Variables/Fields
    private String commonName;
    private String scientificName;
    private String genusName;
    private String category;
    private int sizeInCm;
    private double approxPrice;

    // Constructor
    public Plant(String commonName, String scientificName, String genusName, String category, int sizeInCm, double approxPrice) {
        if (commonName == null || commonName.isEmpty()) {
            throw new IllegalArgumentException("Common Name cannot be null of empty.");
        }
        if (scientificName == null || scientificName.isEmpty()) {
            throw new IllegalArgumentException("Scientific Name cannot be null of empty.");
        }
        if (genusName == null || genusName.isEmpty()) {
            throw new IllegalArgumentException("Genus Name cannot be null of empty.");
        }
        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("Category cannot be null of empty.");
        }
        if (sizeInCm <= 0) {
            throw new IllegalArgumentException("Size In CM cannot be less than 0.");
        }
        if (approxPrice <= 0) {
            throw new IllegalArgumentException("Approx Price cannot be less than 0.");
        }
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.genusName = genusName;
        this.category = category;
        this.sizeInCm = sizeInCm;
        this.approxPrice = approxPrice;
    }

    // Getter Methods:
    public String getCommonName() {
        return commonName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getGenusName() {
        return genusName;
    }

    public String getCategory() {
        return category;
    }

    public int getSizeInCm() {
        return sizeInCm;
    }

    public double getApproxPrice() {
        return approxPrice;
    }

    // Override toString() Method
    @Override
    public String toString() {
        return commonName + " (" + scientificName + ") - Genus: " + genusName +
                ", Category: " + category + ", Size: " + sizeInCm + " cm, Price: €" + String.format("%.2f", approxPrice);
    }

}
