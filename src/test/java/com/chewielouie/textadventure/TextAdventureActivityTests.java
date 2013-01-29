package com.chewielouie.textadventure;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import android.view.MotionEvent;
import android.widget.TextView;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import com.xtremelabs.robolectric.Robolectric;
import org.jmock.*;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(RobolectricTestRunner.class)
public class TextAdventureActivityTests {

    private Mockery mockery = new Mockery();

    private MotionEvent createUpMotionEvent( float x, float y ) {
        long downTime = 0;
        long eventTime = 0;
        int action = MotionEvent.ACTION_UP;
        int metaState = 0;
        return MotionEvent.obtain( downTime, eventTime, action, x, y, metaState );
    }

    private MotionEvent createDownMotionEvent( float x, float y ) {
        long downTime = 0;
        long eventTime = 0;
        int action = MotionEvent.ACTION_DOWN;
        int metaState = 0;
        return MotionEvent.obtain( downTime, eventTime, action, x, y, metaState );
    }

    @Test
    public void renders_the_presenter_on_resume() {
        final RendersView r = mockery.mock( RendersView.class );
        mockery.checking( new Expectations() {{
            oneOf( r ).render();
        }});

        new TextAdventureActivity( r ) {
            // Override to make onResume() accessible for testing
            @Override
            public void onResume() {
                super.onResume();
            }
        }.onResume();

        mockery.assertIsSatisfied();
    }

    @Test
    public void show_room_text_updates_text_view() {
        TextAdventureActivity activity = new TextAdventureActivity();
        activity.onCreate( null );

        activity.showLocationDescription( "cheese" );

        final TextView t = (TextView)activity.findViewById( R.id.main_text_output );
        assertEquals( "cheese", t.getText().toString() );
    }

    @Test
    public void down_touch_event_is_ignored() {
        final UserActionHandler handler = mockery.mock( UserActionHandler.class );
        mockery.checking( new Expectations() {{
            never( handler ).moveThroughExit( with( any( Exit.class ) ) );
        }});
        TextAdventureActivity activity = new TextAdventureActivity( handler );
        activity.onCreate( null );

        List<Exit> exits = new ArrayList<Exit>();
        exits.add( new Exit( "first exit" ) );
        exits.add( new Exit( "second exit" ) );
        activity.showLocationExits( exits );

        activity.dispatchTouchEvent( createDownMotionEvent( 0, 0 ) );

        mockery.assertIsSatisfied();
    }

    @Test
    public void touch_event_in_top_quadrant_causes_first_exit_to_be_used() {
        final UserActionHandler handler = mockery.mock( UserActionHandler.class );
        final Exit exit = new Exit( "first exit" );
        mockery.checking( new Expectations() {{
            oneOf( handler ).moveThroughExit( exit );
            ignoring( handler );
        }});
        TextAdventureActivity activity = new TextAdventureActivity( handler );
        activity.onCreate( null );

        List<Exit> exits = new ArrayList<Exit>();
        exits.add( exit );
        exits.add( new Exit( "second exit" ) );
        activity.showLocationExits( exits );

        float x = 0;
        float y = 0;
        activity.dispatchTouchEvent( createUpMotionEvent( x, y ) );

        mockery.assertIsSatisfied();
    }

    //public void touch_event_in_bottom_quadrant_causes_second_exit_to_be_used() {
    //public void touch_event_in_right_quadrant_causes_third_exit_to_be_used() {
    //public void touch_event_in_left_quadrant_causes_fourth_exit_to_be_used() {

    @Test
    public void touch_event_in_top_quadrant_with_no_exits_is_ignored() {
        final UserActionHandler handler = mockery.mock( UserActionHandler.class );
        mockery.checking( new Expectations() {{
            never( handler ).moveThroughExit( with( any( Exit.class ) ) );
        }});
        TextAdventureActivity activity = new TextAdventureActivity( handler );

        float x = 0;
        float y = 0;
        activity.dispatchTouchEvent( createUpMotionEvent( x, y ) );

        mockery.assertIsSatisfied();
    }
    //public void touch_event_in_second_quadrant_with_only_one_exit_is_ignored() {
    //public void touch_event_in_third_quadrant_with_only_two_exits_is_ignored() {
    //public void touch_event_in_fourth_quadrant_with_only_three_exits_is_ignored() {

    @Test
    public void top_direction_label_uses_first_exit_text() {
        TextAdventureActivity activity = new TextAdventureActivity();
        activity.onCreate( null );

        List<Exit> exits = new ArrayList<Exit>();
        exits.add( new Exit( "first exit" ) );
        exits.add( new Exit( "second exit" ) );
        activity.showLocationExits( exits );

        final TextView t = (TextView)activity.findViewById( R.id.top_direction_label );
        assertEquals( "first exit", t.getText().toString() );
    }

    @Test
    public void bottom_direction_label_uses_second_exit_text() {
        TextAdventureActivity activity = new TextAdventureActivity();
        activity.onCreate( null );

        List<Exit> exits = new ArrayList<Exit>();
        exits.add( new Exit( "first exit" ) );
        exits.add( new Exit( "second exit" ) );
        activity.showLocationExits( exits );

        final TextView t = (TextView)activity.findViewById( R.id.bottom_direction_label );
        assertEquals( "second exit", t.getText().toString() );
    }

    @Test
    public void right_direction_label_uses_third_exit_text() {
        TextAdventureActivity activity = new TextAdventureActivity();
        activity.onCreate( null );

        List<Exit> exits = new ArrayList<Exit>();
        exits.add( new Exit( "first exit" ) );
        exits.add( new Exit( "second exit" ) );
        exits.add( new Exit( "third exit" ) );
        activity.showLocationExits( exits );

        final TextView t = (TextView)activity.findViewById( R.id.right_direction_label );
        assertEquals( "third exit", t.getText().toString() );
    }

    @Test
    public void left_direction_label_uses_fourth_exit_text() {
        TextAdventureActivity activity = new TextAdventureActivity();
        activity.onCreate( null );

        List<Exit> exits = new ArrayList<Exit>();
        exits.add( new Exit( "first exit" ) );
        exits.add( new Exit( "second exit" ) );
        exits.add( new Exit( "third exit" ) );
        exits.add( new Exit( "fourth exit" ) );
        activity.showLocationExits( exits );

        final TextView t = (TextView)activity.findViewById( R.id.left_direction_label );
        assertEquals( "fourth exit", t.getText().toString() );
    }

    @Test
    public void top_direction_label_is_blank_if_no_exits() {
        TextAdventureActivity activity = new TextAdventureActivity();
        activity.onCreate( null );

        List<Exit> exits = new ArrayList<Exit>();
        activity.showLocationExits( exits );

        final TextView t = (TextView)activity.findViewById( R.id.top_direction_label );
        assertEquals( "", t.getText().toString() );
    }

    @Test
    public void bottom_direction_label_is_blank_if_less_than_two_exits() {
        TextAdventureActivity activity = new TextAdventureActivity();
        activity.onCreate( null );

        List<Exit> exits = new ArrayList<Exit>();
        activity.showLocationExits( exits );

        final TextView t = (TextView)activity.findViewById( R.id.bottom_direction_label );
        assertEquals( "", t.getText().toString() );
    }

    @Test
    public void right_direction_label_is_blank_if_less_than_three_exits() {
        TextAdventureActivity activity = new TextAdventureActivity();
        activity.onCreate( null );

        List<Exit> exits = new ArrayList<Exit>();
        activity.showLocationExits( exits );

        final TextView t = (TextView)activity.findViewById( R.id.right_direction_label );
        assertEquals( "", t.getText().toString() );
    }

    @Test
    public void left_direction_label_is_blank_if_less_than_four_exits() {
        TextAdventureActivity activity = new TextAdventureActivity();
        activity.onCreate( null );

        List<Exit> exits = new ArrayList<Exit>();
        activity.showLocationExits( exits );

        final TextView t = (TextView)activity.findViewById( R.id.left_direction_label );
        assertEquals( "", t.getText().toString() );
    }
}
