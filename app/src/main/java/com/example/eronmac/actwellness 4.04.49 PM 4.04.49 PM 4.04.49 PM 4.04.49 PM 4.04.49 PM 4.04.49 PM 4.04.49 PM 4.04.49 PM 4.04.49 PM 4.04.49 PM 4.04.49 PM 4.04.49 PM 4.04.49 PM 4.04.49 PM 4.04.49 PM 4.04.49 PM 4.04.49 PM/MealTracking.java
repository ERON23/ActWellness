package com.example.eronmac.actwellness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//added code
import picturesofmeals.Meal;

import java.math.BigDecimal;
import java.util.*;
import adapters.*;
import android.content.*;
import android.view.View;
import android.widget.*;

import com.google.android.youtube.player.YouTubePlayer;
//added code

public class MealTracking extends AppCompatActivity {

    //added code
    private GridView gridViewMeals;
    private List<Meal> meals = new ArrayList<Meal>();
    //added code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_tracking);

        //added code
        meals.add(new Meal("m01", "Chicken Bowl",  "Serves 4-6\n" +
                "\n" +
                "INGREDIENTS\n" +
                "2-3 boneless skinless chicken breasts\n" +
                "3 bell peppers, any color, sliced\n" +
                "1 large red onion, sliced\n" +
                "2 tablespoons olive oil\n" +
                "1 tablespoon taco seasoning\n" +
                "Salt and pepper\n" +
                "1 jar salsa\n" +
                "3 cups cooked brown rice, divided\n" +
                "1 can black beans, drained and rinsed\n" +
                "1 can corn\n" +
                "1 cup shredded cheddar cheese\n" +
                "1 lime, sliced into wedges \n" +
                "Fresh cilantro to garnish\n" +
                "\n" +
                "\n" +
                "PREPARATION\n" +
                "Preheat oven to 400˚F/200˚C.\n" +
                "Line a baking sheet with foil.\n" +
                "Place the chicken, peppers, and onions onto the baking sheet and drizzle with oil.\n" +
                "Sprinkle the taco seasoning evenly over both sides of the chicken breasts. \n" +
                "Salt and pepper the peppers and onions, tossing to coat. \n" +
                "Top each chicken breast with a generous pour of salsa.\n" +
                "Bake in a preheated oven for 25 minutes. \n" +
                "Rest chicken for 10 minutes, before slicing into strips. \n" +
                "Add a base of brown rice to 4 food storage containers. Top each with a scoop of black beans, corn, additional salsa, cheddar cheese, cooked peppers and onions, and sliced chicken. Garnish with fresh cilantro and a lime wedge. \n" +
                "Store in the refrigerator (and enjoy any extras immediately). Can be kept refrigerated for up to 4 days. \n" +
                "Meal-prep FTW! Enjoy!" , BigDecimal.valueOf(100), R.drawable.meal_prep1 ));


        meals.add(new Meal("m02", "Pasta Bake Meal",  "Caprese\n" +
                "Servings: 2\n" +
                "INGREDIENTS\n" +
                "2 cups pasta, cooked al dente\n" +
                "¾ cup onions, chopped\n" +
                "1 cup marinara sauce\n" +
                "⅓ cup basil, chopped\n" +
                "1 teaspoon salt\n" +
                "1 teaspoon pepper\n" +
                "Mozzarella (optional)\n\n" +
                "PREPARATION\n" +
                "Preheat oven to 400ºF/200ºC.\n" +
                "Take two sheets of aluminum foil (about 12x12-inch) and stack them on top of each other.\n" +
                "Fold one side of the foil about ⅓ of the way across sheet, repeat for opposite side. Pinch the corner to form a point and then flatten it to the short side of the foil, forming a raised corner. Repeat for all four sides, and make four of these.\n" +
                "Add all of the ingredients to one of the foil boats, then stir.\n" +
                "Bake for 12 minutes.\n" +
                "Allow to cool for 10 minutes.\n" +
                "Eat or pack into tupperware and refrigerate 3-5 days.\n" +
                "Alfredo\n" +
                "Servings: 2\n\n" +
                "INGREDIENTS\n" +
                "2 cups pasta, cooked al dente\n" +
                "½ cup carrots, sliced\n" +
                "½ cup broccoli\n" +
                "¾ cup alfredo sauce (from a jar is fine)\n" +
                "1 teaspoon salt\n" +
                "1 teaspoon pepper\n\n" +
                "PREPARATION\n" +
                "Preheat oven to 400ºF/200ºC.\n" +
                "Take two sheets of aluminum foil (about 12x12-inch) and stack them on top of each other.\n" +
                "Fold one side of the foil about ⅓ of the way across sheet, repeat for opposite side. Pinch the corner to form a point and then flatten it to the short side of the foil, forming a raised corner. Repeat for all four sides, and make four of these.\n" +
                "Add all of the ingredients to one of the foil boats, then stir.\n" +
                "Bake for 12 minutes.\n" +
                "Allow to cool for 10 minutes.\n" +
                "Eat or pack into tupperware and refrigerate 3-5 days.\n" +
                "Pesto\n" +
                "Servings: 2\n\n" +
                "INGREDIENTS\n" +
                "2 cups pasta, cooked al dente\n" +
                "1 cup cherry tomatoes, halved\n" +
                "¾ cup pesto\n" +
                "1 teaspoon salt\n" +
                "1 teaspoon pepper\n" +
                "Parmesan cheese (optional)\n\n" +
                "PREPARATION\n" +
                "Preheat oven to 400ºF/200ºC.\n" +
                "Take two sheets of aluminum foil (about 12x12-inch) and stack them on top of each other.\n" +
                "Fold one side of the foil about ⅓ of the way across sheet, repeat for opposite side. Pinch the corner to form a point and then flatten it to the short side of the foil, forming a raised corner. Repeat for all four sides, and make four of these.\n" +
                "Add all of the ingredients to one of the foil boats, then stir.\n" +
                "Bake for 12 minutes.\n" +
                "Allow to cool for 10 minutes.\n" +
                "Eat or pack into tupperware and refrigerate 3-5 days.\n" +
                "Garlic Primavera\n" +
                "Servings: 2\n\n" +
                "INGREDIENTS\n" +
                "2 cups pasta, cooked al dente\n" +
                "½ cup carrots, sliced\n" +
                "¾ cup peppers, chopped\n" +
                "¾ cup asparagus\n" +
                "1 tablespoon garlic, minced\n" +
                "1 tablespoon olive oil\n" +
                "1 teaspoon salt\n" +
                "1 teaspoon pepper\n" +
                "Parmesan cheese (optional)\n\n" +
                "PREPARATION\n" +
                "Preheat oven to 400ºF/200ºC.\n" +
                "Take two sheets of aluminum foil (about 12x12-inch) and stack them on top of each other.\n" +
                "Fold one side of the foil about ⅓ of the way across sheet, repeat for opposite side. Pinch the corner to form a point and then flatten it to the short side of the foil, forming a raised corner. Repeat for all four sides, and make four of these.\n" +
                "Add all of the ingredients to one of the foil boats, then stir.\n" +
                "Bake for 12 minutes.\n" +
                "Allow to cool for 10 minutes.\n" +
                "Eat or pack into tupperware and refrigerate 3-5 days." , BigDecimal.valueOf(200), R.drawable.meal_prep2 ));


        meals.add(new Meal("m03", "One Pot Shrimp Pasta", "Servings: 8\n" +
                "\n" +
                "INGREDIENTS\n" +
                "2 tablespoon butter\n" +
                "1 pound shrimp, peeled and deveined\n" +
                "Salt, to taste\n" +
                "Black pepper, to taste\n" +
                "3 cloves garlic, minced\n" +
                "½ pound bacon, cooked, cut into small strips\n" +
                "7 ounces baby spinach\n" +
                "1½ cups heavy cream\n" +
                "1 pound fettuccine, cooked\n" +
                "¾ cup parmesan cheese, grated\n" +
                "⅓ cup parsley, chopped\n" +
                "\n" +
                "PREPARATION\n" +
                "1. In a large pot, heat the butter over medium-high heat until browned.\n" +
                "2. Toss in the shrimp and season with salt and black pepper. Sear just until pink on both sides. Remove the shrimp from the pot and set aside.\n" +
                "3. Sauté the garlic and bacon until fragrant, about 30 seconds. Add in the spinach and stir until it begins to wilt.\n" +
                "4. Pour in the heavy cream and stir the pot to combine. Let the sauce come up to a simmer and reduce until thick and creamy, about 5 minutes.\n" +
                "5. Toss in the fettuccine, sprinkle over the parmesan cheese, and toss to combine.\n" +
                "6. Sprinkle in the parsley and add the shrimp back to the pot. Toss until everything has warmed through.\n" +
                "7. Remove from heat and serve.\n" +
                "8. Enjoy!" , BigDecimal.valueOf(300), R.drawable.meal_prep3 ));


        meals.add(new Meal("m04", "Avocado Chickpea Salad",  "Servings: 4\n" +
                "\n" +
                "INGREDIENTS\n" +
                "2 tablespoons sesame oil\n" +
                "3 cloves garlic, minced\n" +
                "2 chicken breasts, diced\n" +
                "Salt, to taste\n" +
                "Pepper, to taste\n" +
                "1 cup carrots, diced\n" +
                "1 cup broccoli florets\n" +
                "2 cups brown rice, cooked\n" +
                "½ cup frozen peas\n" +
                "3 tablespoons low-sodium soy sauce\n" +
                "\n" +
                "PREPARATION\n" +
                "Heat sesame oil in a skillet, and cook garlic until softened. \n" +
                "Add the chicken, salt, and pepper, and sauté for 5 minutes.\n" +
                "Add the carrots and broccoli, and sauté until tender.\n" +
                "Add the rice, soy sauce, and peas, and mix thoroughly. \n" +
                "Enjoy! " , BigDecimal.valueOf(100), R.drawable.meal_prep4 ));


        meals.add(new Meal("m05", "Chicken Meal Prep", "Servings: 4\n" +
                "\n" +
                "INGREDIENTS \n" +
                "Dressing\n" +
                "2 tablespoons olive oil\n" +
                "¼ cup lime juice\n" +
                "2 teaspoons cumin\n" +
                "2 teaspoons chili powder\n" +
                "1 teaspoon salt\n" +
                "1 teaspoon pepper \n" +
                "¼ cup cilantro, chopped \n" +
                "\n" +
                "Salad\n" +
                "2 cans chickpeas, drained and rinsed\n" +
                "1 cucumber, chopped and quartered\n" +
                "20 cherry tomatoes, halved \n" +
                "1 onion, chopped \n" +
                "1 avocado, diced \n" +
                "⅓ cup carrots, shredded \n" +
                "\n" +
                "PREPARATION \n" +
                "Dressing\n" +
                "1. Combine dressing ingredients in a small bowl. Whisk together until mixed thoroughly. \n" +
                "\n" +
                "Salad \n" +
                "1. In a large bowl, combine chickpeas, cucumber, tomatoes, onion, avocado, carrots, and dressing.\n" +
                "2. Toss together until evenly combined. \n" +
                "3. Enjoy! ",
                BigDecimal.valueOf(100), R.drawable.meal_prep5 ));


        this.gridViewMeals = (GridView) findViewById(R.id.gridViewMeals);
        this.gridViewMeals.setAdapter(new MealListAdapter(this, meals));
        this.gridViewMeals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Meal meal = meals.get(position);
                Intent intent = new Intent(MealTracking.this,MealDetailActivity.class);
                intent.putExtra("Meal" , meal);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(), meal.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        //added code

    }
    public void goToWaterIntake (View view) {

        Intent intent = new Intent(MealTracking.this, WaterIntake.class);
        startActivity(intent);
    }
}
