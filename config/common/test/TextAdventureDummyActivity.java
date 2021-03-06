package REPLACE_ME;

import java.lang.reflect.Field;
import android.graphics.Bitmap;

import com.chewielouie.textadventure_common.TextAdventureCommonActivity;
import com.chewielouie.textadventure.BasicModelFactory;
import com.chewielouie.textadventure.RendersView;
import com.chewielouie.textadventure.UserActionHandler;

public class TextAdventureDummyActivity extends TextAdventureCommonActivity {

    public TextAdventureDummyActivity() {
        super();
    }

    public TextAdventureDummyActivity( RendersView r ) {
        super( r );
    }

    public TextAdventureDummyActivity( BasicModelFactory modelFactory ) {
        super( modelFactory );
    }

    public TextAdventureDummyActivity( RendersView r, BasicModelFactory modelFactory ) {
        super( r, modelFactory );
    }

    public TextAdventureDummyActivity( UserActionHandler u ) {
        super( u );
    }

    protected Bitmap getMap() {
        return null;
    }

    protected int R_drawable_tta_button() {
        return R.drawable.tta_button00;
    }

    protected int R_drawable_tta_button(String buttonName) {
        return R.drawable.tta_button00;
    }

    public int R_id_available_actions() {
        return R.id.available_actions;
    }

    public int R_id_location_text_view() {
        return R.id.location_text_view;
    }

    public int R_id_map_view() {
        return R.id.map_view;
    }

    protected int R_id_walkthrough_scroll_view() {
        return R.id.walkthrough_scroll_view;
    }

    protected int R_id_walkthrough_text_view() {
        return R.id.walkthrough_text_view;
    }

    public int R_id_main_text_output() {
        return R.id.main_text_output;
    }

    public int R_id_main_text_output_scroll_view() {
        return R.id.main_text_output_scroll_view;
    }

    public int R_id_options_font_example_text() {
        return R.id.options_font_example_text;
    }

    public int R_id_options_font_size_picker() {
        return R.id.options_font_size_picker;
    }

    protected int R_id_options_tts_enabled() {
        return R.id.options_tts_enabled;
    }

    public int R_id_score_text_view() {
        return R.id.score_text_view;
    }

    protected int R_id_new_game_welcome_dialog_continue_button() {
        return R.id.new_game_welcome_dialog_continue_button;
    }

    protected int R_id_whats_new_dialog_continue_button() {
        return R.id.whats_new_dialog_continue_button;
    }

    protected int R_id_about_dialog_title() {
        return R.id.about_dialog_title;
    }

    protected int R_id_about_dialog_main_text() {
        return R.id.about_dialog_main_text;
    }

    protected int R_string_whats_new_dialog_text() {
        return R.string.whats_new_dialog_text;
    }

    public int R_layout_about_dialog() {
        return R.layout.about_dialog;
    }

    public int R_layout_main() {
        return R.layout.main;
    }

    public int R_layout_options_dialog() {
        return R.layout.options_dialog;
    }

    protected int R_layout_new_game_welcome_dialog() {
        return R.layout.new_game_welcome_dialog;
    }

    protected int R_layout_whats_new_dialog() {
        return R.layout.whats_new_dialog;
    }

    public int R_raw_model_content() {
        return R.raw.model_content;
    }

    public int R_string_about() {
        return R.string.about;
    }

    public int R_string_app_name() {
        return R.string.app_name;
    }

    public int R_string_completed() {
        return R.string.completed;
    }

    public int R_string_new_game() {
        return R.string.new_game;
    }

    public int R_string_new_game_title() {
        return R.string.new_game_title;
    }

    public int R_string_new_game_confirmation_dialog_text() {
        return R.string.new_game_confirmation_dialog_text;
    }

    public int R_string_no() {
        return R.string.no;
    }

    public int R_string_options() {
        return R.string.options;
    }

    public int R_string_options_title() {
        return R.string.options_title;
    }

    public int R_string_options_save() {
        return R.string.options_save;
    }

    public int R_string_options_cancel() {
        return R.string.options_cancel;
    }

    public int R_string_show_map() {
        return R.string.show_map;
    }

    public int R_string_yes() {
        return R.string.yes;
    }

    protected int R_string_walkthrough() {
        return R.string.walkthrough;
    }

    protected int R_string_quick_hint() {
        return R.string.quick_hint;
    }

    protected int R_string_loading() {
        return R.string.loading;
    }

    protected int R_string_new_game_welcome_dialog_title() {
        return R.string.new_game_welcome_dialog_title;
    }

    protected int R_string_new_game_welcome_dialog_text() {
        return R.string.new_game_welcome_dialog_text;
    }

    protected int R_string_new_game_welcome_dialog_continue_button() {
        return R.string.new_game_welcome_dialog_continue_button;
    }

    protected int R_string_about_dialog_text() {
        return R.string.about_dialog_text;
    }

    protected Field[] R_raw_class_getFields() {
        return R.raw.class.getFields();
    }

    protected int R_style_WaypointDialogTheme() {
        return R.style.WaypointDialogTheme;
    }

    @Override
    protected boolean needToShowWhatsNew() {
        return false;
    }

    protected int R_xml_app_tracker() {
        return R.xml.app_tracker;
    }

    protected int R_xml_debug_app_tracker() {
        return R.xml.debug_app_tracker;
    }
}
