package main.najah.test;

import main.najah.code.Recipe;
import main.najah.code.RecipeBook;
import main.najah.code.RecipeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeBookTest {

    private RecipeBook recipeBook;
    private Recipe recipe1;
    private Recipe recipe2;

    @BeforeEach
    void setUp() throws RecipeException {
        recipeBook = new RecipeBook();

        recipe1 = new Recipe();
        recipe1.setName("Cappuccino");
        recipe1.setAmtCoffee("2");
        recipe1.setAmtMilk("1");
        recipe1.setAmtSugar("1");
        recipe1.setAmtChocolate("0");
        recipe1.setPrice("50");

        recipe2 = new Recipe();
        recipe2.setName("Mocha");
        recipe2.setAmtCoffee("1");
        recipe2.setAmtMilk("1");
        recipe2.setAmtSugar("2");
        recipe2.setAmtChocolate("1");
        recipe2.setPrice("60");
    }

    @Test
    void testAddRecipeSuccessfully() {
        assertTrue(recipeBook.addRecipe(recipe1));
    }

    @Test
    void testAddDuplicateRecipe() {
        assertTrue(recipeBook.addRecipe(recipe1));
        assertFalse(recipeBook.addRecipe(recipe1)); // same name
    }

    @Test
    void testAddRecipeExceedsLimit() throws RecipeException {
        for (int i = 0; i < 4; i++) {
            Recipe r = new Recipe();
            r.setName("Recipe" + i);
            r.setAmtCoffee("1");
            r.setAmtMilk("1");
            r.setAmtSugar("1");
            r.setAmtChocolate("1");
            r.setPrice("10");
            assertTrue(recipeBook.addRecipe(r));
        }

        // Should fail to add the 5th one
        assertFalse(recipeBook.addRecipe(recipe1));
    }

    @Test
    void testDeleteRecipeSuccessfully() {
        recipeBook.addRecipe(recipe1);
        String deletedName = recipeBook.deleteRecipe(0);
        assertEquals("Cappuccino", deletedName);
        assertNotEquals("Cappuccino", recipeBook.getRecipes()[0].getName()); // should be blank
    }

    @Test
    void testDeleteRecipeInvalidIndex() {
        assertNull(recipeBook.deleteRecipe(3)); // not added yet
    }

    @Test
    void testEditRecipeSuccessfully() {
        recipeBook.addRecipe(recipe1);
        String oldName = recipeBook.editRecipe(0, recipe2);
        assertEquals("Cappuccino", oldName);
        assertEquals("", recipeBook.getRecipes()[0].getName()); // edited recipe name gets reset
    }

    @Test
    void testEditRecipeInvalidIndex() {
        assertNull(recipeBook.editRecipe(2, recipe2));
    }

    @Test
    void testGetRecipesReturnsSameContent() {
        recipeBook.addRecipe(recipe1);
        Recipe[] recipes = recipeBook.getRecipes();
        assertEquals("Cappuccino", recipes[0].getName());
    }

    @Test
    void testEditRecipeClearsName() {
        recipeBook.addRecipe(recipe1);
        recipeBook.editRecipe(0, recipe2);
        assertEquals("", recipeBook.getRecipes()[0].getName());
    }

    @Test
    void testDeleteRecipeSetsNewRecipeObject() {
        recipeBook.addRecipe(recipe1);
        recipeBook.deleteRecipe(0);
        Recipe r = recipeBook.getRecipes()[0];
        assertNotNull(r);
        assertEquals("", r.getName());
        assertEquals(0, r.getPrice());
    }

    @Test
    void testRecipeSetterMethodsThrowsRecipeException() {
        // Testing invalid input for recipe attributes
        Recipe invalidRecipe = new Recipe();

        // Invalid coffee amount (non-integer input)
        assertThrows(RecipeException.class, () -> invalidRecipe.setAmtCoffee("invalid"));

        // Invalid milk amount (negative integer)
        assertThrows(RecipeException.class, () -> invalidRecipe.setAmtMilk("-1"));

        // Invalid price (negative integer)
        assertThrows(RecipeException.class, () -> invalidRecipe.setPrice("-100"));
    }

    @Test
    void testEqualsAndHashCode() {
        recipe1.setName("Espresso");
        Recipe anotherRecipe1 = new Recipe();
        anotherRecipe1.setName("Espresso");

        assertTrue(recipe1.equals(anotherRecipe1)); // Should be equal by name
        assertEquals(recipe1.hashCode(), anotherRecipe1.hashCode()); // Same hashCode for same name

        Recipe differentRecipe = new Recipe();
        differentRecipe.setName("Latte");

        assertFalse(recipe1.equals(differentRecipe)); // Should not be equal
    }

    @Test
    void testToString() {
        recipe1.setName("Latte");
        assertEquals("Latte", recipe1.toString()); // toString should return the name
    }
}
