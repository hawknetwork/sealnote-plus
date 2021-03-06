package org.hawknetwork.sealnoteplus.view.staggeredgrid;

import android.database.Cursor;
import android.util.Log;
import android.view.ViewStub;
import android.widget.AdapterView;
import com.nhaarman.listviewanimations.swinginadapters.AnimationAdapter;
import com.nhaarman.listviewanimations.swinginadapters.prepared.ScaleInAnimationAdapter;
import org.hawknetwork.sealnoteplus.R;
import org.hawknetwork.sealnoteplus.data.NoteListAdapter;
import org.hawknetwork.sealnoteplus.fragment.NoteListFragment;
import org.hawknetwork.sealnoteplus.utils.PreferenceHandler;

/**
 * Fragment where all cards are listed in a staggered grid
 */
public class StaggeredGridFragment extends NoteListFragment {
    public final static String TAG = "StaggeredGridFragment";

    /**
     * Create and return adapter
     */
    @Override
    protected NoteListAdapter createAdapter() {
        if (mAdapter == null) {
            mAdapter = new StaggeredGridAdapter(getActivity(), null);
        }
        return mAdapter;
    }

    /**
     * Inflate ViewStub with Staggered Grid View. If user has selected
     * VIEW_COLUMN mode, then we load singlecolumn view.
     *
     * @param stub  ViewStub to be replaced with adapter view
     * @return      StaggeredGridView
     */
    @Override
    protected AdapterView inflateAdapterView(ViewStub stub) {
        if (PreferenceHandler.getNoteListViewType(getActivity()) ==
                PreferenceHandler.NoteListViewType.VIEW_COLUMN) {
            stub.setLayoutResource(R.layout.singlecolumnview);
        } else {
            stub.setLayoutResource(R.layout.staggeredgrid);
        }
        return (AdapterView) stub.inflate();
    }

    /**
     * Load adapter to card grid view. Reload data from database. Also setup animations.
     */
    protected void loadAdapter(Cursor cursor) {
        Log.d(TAG, "Loading adapter into view");
        setAnimationAdapter();
        mAdapter.changeCursor(cursor);
    }

    /**
     * Set animation adapter for card grid view and make it card grid's external adapter.
     */
    private void setAnimationAdapter() {
        StaggeredGridAdapter dataAdapter = (StaggeredGridAdapter) mAdapter;
        StaggeredGridView adapterView = (StaggeredGridView) mAdapterView;

        AnimationAdapter animCardArrayAdapter = new ScaleInAnimationAdapter(dataAdapter);

        animCardArrayAdapter.setAnimationDurationMillis(1000);
        animCardArrayAdapter.setAnimationDelayMillis(500);

        animCardArrayAdapter.setAbsListView(adapterView);
        adapterView.setExternalAdapter(animCardArrayAdapter, dataAdapter);
    }
}
