package adapters;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.*;
import picturesofmeals.*;
import android.content.*;
import android.view.*;

import com.example.eronmac.actwellness.R;

import java.util.*;

public class MealListAdapter extends ArrayAdapter<Meal>{

    private Context context;
    private List<Meal> meals;

    public MealListAdapter (Context context, List<Meal> meals){
        super (context, R.layout.meal_list_layout, meals);
        this.context = context;
        this.meals = meals;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.meal_list_layout, parent, false);
        Meal meal = meals.get(position);
        ImageView imageViewPhoto = (ImageView) view.findViewById(R.id.imageViewPhoto);
        imageViewPhoto.setImageResource(meal.getPhoto());
        TextView textViewName = (TextView) view.findViewById(R.id.textViewName);
        textViewName.setText(meal.getName());

        return view;
    }
}
