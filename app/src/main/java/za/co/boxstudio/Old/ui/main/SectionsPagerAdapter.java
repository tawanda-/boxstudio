package za.co.boxstudio.Old.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import za.co.boxstudio.Old.tab1;
import za.co.boxstudio.Old.tab2;
import za.co.boxstudio.Old.tab3;
import za.co.boxstudio.Old.tab4;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
               tab1 Tab1 = new tab1();
                return Tab1;
            case 1:
                tab2 Tab2 = new tab2();
                return Tab2;

                case 2:
                    tab3 Tab3 = new tab3();
                    return Tab3;

            case 3:
                tab4 Tab4 = new tab4();
                return Tab4;
            default:
                 return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                return "Profile";
            case 1:
                return "Schedule";
            case 2:
                return "Booking";
            case 3:
                return "AboutUs";
        }
            return null;
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 4;
    }
}