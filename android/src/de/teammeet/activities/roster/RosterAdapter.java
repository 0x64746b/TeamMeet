package de.teammeet.activities.roster;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.viewpagerindicator.TitleProvider;

import de.teammeet.R;

public class RosterAdapter extends FragmentPagerAdapter implements TitleProvider {

	private static final String CLASS = RosterAdapter.class.getSimpleName();
	private static final int NUM_FRAGMENTS = 2;
	
	public static final int CONTACTS_FRAGMENT_POS = 0;
	public static final int TEAMS_FRAGMENT_POS = 1;

	private ViewGroup mViewPager;

	
	public RosterAdapter(FragmentManager fm, ViewGroup pager) {
		super(fm);
		mViewPager = pager;
	}

	@Override
	public Fragment getItem(int position) {
		Fragment newFragment = null;
		
		switch (position) {
		case CONTACTS_FRAGMENT_POS:
			newFragment = new ContactsFragment();
			break;
		case TEAMS_FRAGMENT_POS:
			newFragment = new Teams();
			break;
		}
		
		return newFragment;
	}

	@Override
	public int getCount() {
		return NUM_FRAGMENTS;
	}

	public Fragment getFragment(int position) {
		return (Fragment) super.instantiateItem(mViewPager, position);
	}
	
	public String getTitle(int position) {
		Context context = mViewPager.getContext();
		String title = "ENOTITLE";
		switch (position) {
			case CONTACTS_FRAGMENT_POS:
				title = context.getString(R.string.tab_contacts);
				break;
			case TEAMS_FRAGMENT_POS:
				title = context.getString(R.string.tab_teams);
				break;
		}
		return title;
	}
}
