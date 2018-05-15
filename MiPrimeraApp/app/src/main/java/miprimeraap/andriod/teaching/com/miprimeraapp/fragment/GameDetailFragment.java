package miprimeraap.andriod.teaching.com.miprimeraapp.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import miprimeraap.andriod.teaching.com.miprimeraapp.GameModel;
import miprimeraap.andriod.teaching.com.miprimeraapp.GamesInteractor;
import miprimeraap.andriod.teaching.com.miprimeraapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameDetailFragment extends Fragment {


    public GameDetailFragment() {
        // Required empty public constructor
    }
    public static GameDetailFragment newInstance(int gameId){
        GameDetailFragment fragment = new GameDetailFragment();
        Bundle myBundle = new Bundle();
        myBundle.putInt("app_id",gameId);
        fragment.setArguments(myBundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int gameId = getArguments().getInt("app_id", 0);
        final GameModel game = new GamesInteractor().getGameWithId(gameId);
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_game_detail, container, false);

        ImageView icono = fragmentView.findViewById(R.id.image1);
        icono.setImageResource(game.getIconDrawable());

        ImageView fondo = fragmentView.findViewById(R.id.image);
        fondo.setImageResource(game.getBackgroundDrawable());

        TextView texto = fragmentView.findViewById(R.id.text);
        texto.setText(game.getDescription());

        Button boton = fragmentView.findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(game.getOficialWebsiteUr()));
                startActivity(webIntent);
            }
        });

        return fragmentView;
    }

}
