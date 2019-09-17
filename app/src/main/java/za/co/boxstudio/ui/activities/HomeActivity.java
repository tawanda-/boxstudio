package za.co.boxstudio.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import za.co.boxstudio.ui.fragments.BookingFragment;
import za.co.boxstudio.ui.fragments.ContactUsFragment;
import za.co.boxstudio.ui.fragments.ProfileFragment;
import za.co.boxstudio.ui.fragments.ScheduleFragment;
import za.co.boxstudio.R;

public class HomeActivity extends AppCompatActivity {

    ViewPager pager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        pager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tabs);

        pager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(pager);

        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    public class MyAdapter extends FragmentPagerAdapter {
        private String[] titles = { getString(R.string.title_profile_fragment),
                getString(R.string.title_schedule_fragment),
                getString(R.string.title_booking_fragment),
                getString(R.string.title_contact_us_fragment)};

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:{
                    return ProfileFragment.newInstance(position);
                }
                case 1:{
                    return ScheduleFragment.newInstance(position);
                }
                case 2:{
                    return BookingFragment.newInstance(position);
                }
                case 3:{
                    return ContactUsFragment.newInstance(position);
                }
            }
            return null;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
