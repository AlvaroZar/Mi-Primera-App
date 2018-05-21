package miprimeraap.andriod.teaching.com.miprimeraapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import miprimeraap.andriod.teaching.com.miprimeraapp.fragment.GameDetailFragment;

public class GameDetailActivity extends AppCompatActivity implements GameDetailView{

    private GameDetailPresenter presenter;
    private int currentPosition;
    private MyPagerAdapter myPagerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);

        presenter = new GameDetailPresenter();

        currentPosition = getIntent().getIntExtra("position",0);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.startPresenting(this);
        final ViewPager myViewPager = findViewById(R.id.view_pager);
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        myViewPager.setAdapter(myPagerAdapter);
        myViewPager.setCurrentItem(currentPosition);
        getSupportActionBar().setTitle(myPagerAdapter.getPageTitle(currentPosition));
        myViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            getSupportActionBar().setTitle(myPagerAdapter.getPageTitle(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onGameLoaded(GameModel game) {

    }
    private class MyPagerAdapter extends FragmentStatePagerAdapter{


        public MyPagerAdapter(FragmentManager fm) {
            super(fm);


        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return presenter.getGames().get(position).getName();
        }

        @Override
        public Fragment getItem(int position) {
            int gameId = presenter.getGames().get(position).getId();
            return GameDetailFragment.newInstance(gameId);
        }


        @Override
        public int getCount() {
            return presenter.getGames().size();
        }
    }

}
