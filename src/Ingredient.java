public class Ingredient implements Comparable {

    private String name;
    private float amount;

    public Ingredient(String name){
        this(name, 1);
    }

    public Ingredient(String name, float amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public int compareTo(Object o) {

        if (o instanceof Ingredient) {

            Ingredient ingredient = (Ingredient) o;


            if (ingredient.equals(this)) {
                return 0;
            }

            // See if the name of the ingredient is the same type, but the amount is different
            // If the amounts are different, the one with LESS in its container goes first in the order (negative comparison)
            // If the amounts are the same, we will assume that this is the same ingredient and container.
            if (ingredient.name.equals(this.name)) {

                if (ingredient.amount > this.amount) {
                    return -1;
                } else if (ingredient.amount < this.amount) {
                    return 1;
                }

            }

            // If the ingredients don't have the same name, simply go alphabetical.
            return this.name.compareTo(ingredient.name);

        }

        // this return statement should never happen.
        return 0;
    }

    @Override
    public boolean equals(Object o) {

        if (o instanceof Ingredient) {

            Ingredient ingredient = (Ingredient) o;

            // Both the name and amount of an ingredient must be the same for them to ACTUALLY be the same ingredient.
            // For example, I may have two salts, but in different containers with different amounts.
            if (!ingredient.name.equals(this.name)) {
                return false;
            }

            if (ingredient.amount != this.amount) {
                return false;
            }
        }

        return true;
    }

    public boolean sameIngredientType(Ingredient other){
        if (other.name.equals(this.name)) {
            return true;
        }

        return false;
    }


}