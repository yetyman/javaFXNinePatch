import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

public class NinePatchTestController extends GridPane {
    @FXML // fx:id="horizontalPaddingSlider1"
    private Slider horizontalPaddingSlider1; // Value injected by FXMLLoader

    @FXML // fx:id="horizontalPaddingSlider2"
    private Slider horizontalPaddingSlider2; // Value injected by FXMLLoader

    @FXML // fx:id="horizontalPaddingSlider3"
    private Slider horizontalPaddingSlider3; // Value injected by FXMLLoader

    @FXML // fx:id="horizontalPaddingSlider4"
    private Slider horizontalPaddingSlider4; // Value injected by FXMLLoader

    @FXML // fx:id="horizontalPaddingSlider5"
    private Slider horizontalPaddingSlider5; // Value injected by FXMLLoader

    @FXML // fx:id="horizontalPaddingSlider6"
    private Slider horizontalPaddingSlider6; // Value injected by FXMLLoader

    @FXML // fx:id="ninePatch1"
    private NinePatchPane ninePatch1; // Value injected by FXMLLoader

    @FXML // fx:id="ninePatch2"
    private NinePatchPane ninePatch2; // Value injected by FXMLLoader

    @FXML // fx:id="verticalPaddingSlider1"
    private Slider verticalPaddingSlider1; // Value injected by FXMLLoader

    @FXML // fx:id="verticalPaddingSlider2"
    private Slider verticalPaddingSlider2; // Value injected by FXMLLoader

    @FXML // fx:id="verticalPaddingSlider3"
    private Slider verticalPaddingSlider3; // Value injected by FXMLLoader

    @FXML // fx:id="verticalPaddingSlider4"
    private Slider verticalPaddingSlider4; // Value injected by FXMLLoader

    @FXML // fx:id="verticalPaddingSlider5"
    private Slider verticalPaddingSlider5; // Value injected by FXMLLoader

    @FXML // fx:id="verticalPaddingSlider6"
    private Slider verticalPaddingSlider6; // Value injected by FXMLLoader

    @FXML // fx:id="imageRepeatHCB"
    private CheckBox imageRepeatHCB; // Value injected by FXMLLoader

    @FXML // fx:id="imageRepeatVCB"
    private CheckBox imageRepeatVCB; // Value injected by FXMLLoader

    @FXML // fx:id="titleText"
    private TextField titleText; // Value injected by FXMLLoader

    public NinePatchTestController() {
        super();

    }

    @FXML
    void anchorTitleB(ActionEvent event) {
        ninePatch2.setTitleHPos(HPos.CENTER);
        ninePatch2.setTitleVPos(VPos.BOTTOM);
    }

    @FXML
    void anchorTitleBL(ActionEvent event) {
        ninePatch2.setTitleHPos(HPos.LEFT);
        ninePatch2.setTitleVPos(VPos.BOTTOM);

    }

    @FXML
    void anchorTitleBR(ActionEvent event) {
        ninePatch2.setTitleHPos(HPos.RIGHT);
        ninePatch2.setTitleVPos(VPos.BOTTOM);

    }

    @FXML
    void anchorTitleC(ActionEvent event) {
        ninePatch2.setTitleHPos(HPos.CENTER);
        ninePatch2.setTitleVPos(VPos.CENTER);

    }

    @FXML
    void anchorTitleL(ActionEvent event) {
        ninePatch2.setTitleHPos(HPos.LEFT);
        ninePatch2.setTitleVPos(VPos.CENTER);

    }

    @FXML
    void anchorTitleR(ActionEvent event) {
        ninePatch2.setTitleHPos(HPos.RIGHT);
        ninePatch2.setTitleVPos(VPos.CENTER);

    }

    @FXML
    void anchorTitleT(ActionEvent event) {
        ninePatch2.setTitleHPos(HPos.CENTER);
        ninePatch2.setTitleVPos(VPos.TOP);

    }

    @FXML
    void anchorTitleTL(ActionEvent event) {
        ninePatch2.setTitleHPos(HPos.LEFT);
        ninePatch2.setTitleVPos(VPos.TOP);

    }

    @FXML
    void anchorTitleTR(ActionEvent event) {
        ninePatch2.setTitleHPos(HPos.RIGHT);
        ninePatch2.setTitleVPos(VPos.TOP);

    }

    @FXML
    void selectImage(ActionEvent event) {
        var file = new FileChooser().showOpenDialog(this.getScene().getWindow());
        if(file!=null) {
            String path = file.toURI().toString();
            var img = new Image(path);
            ninePatch1.setBackground(img);
            ninePatch2.setBackground(img);
        }
    }
    @FXML
    void selectTitleImage(ActionEvent event) {
        var file = new FileChooser().showOpenDialog(this.getScene().getWindow());
        if(file!=null) {
            String path = file.toURI().toString();
            var img = new Image(path);
            ninePatch1.setTitleBackground(img);
            ninePatch2.setTitleBackground(img);
        }
    }

    @FXML
    void setImageRepeatH(ActionEvent event) {
        ninePatch1.setBackgroundHRepeat(imageRepeatHCB.isSelected()? BackgroundRepeat.REPEAT : BackgroundRepeat.NO_REPEAT);
        ninePatch2.setBackgroundHRepeat(imageRepeatHCB.isSelected()? BackgroundRepeat.REPEAT : BackgroundRepeat.NO_REPEAT);
    }

    @FXML
    void setImageRepeatV(ActionEvent event) {
        ninePatch1.setBackgroundVRepeat(imageRepeatVCB.isSelected()? BackgroundRepeat.REPEAT : BackgroundRepeat.NO_REPEAT);
        ninePatch2.setBackgroundVRepeat(imageRepeatVCB.isSelected()? BackgroundRepeat.REPEAT : BackgroundRepeat.NO_REPEAT);
    }


    @FXML
    void toggleBorders(ActionEvent event) {
        if (ninePatch1.getPatchBorder() == null) {
            ninePatch1.setPatchBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.DASHED, new CornerRadii(4), BorderStroke.THIN)));
            ninePatch2.setPatchBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.DASHED, new CornerRadii(4), BorderStroke.THIN)));
        }else{
            ninePatch1.setPatchBorder(null);
            ninePatch2.setPatchBorder(null);
        }
    }

    public void init() {
        ninePatch2.setTitle("hi i'm jody!");
        ninePatch2.setTitleShown(true);
        ninePatch1.init();
        ninePatch2.init();
        titleText.textProperty().bindBidirectional(ninePatch2.titleProperty);

        GridPane.setFillHeight(ninePatch1, false);
        GridPane.setFillWidth(ninePatch1, false);
        GridPane.setFillHeight(ninePatch2, false);
        GridPane.setFillWidth(ninePatch2, false);

        ninePatch1.contentChildren.add(new VBox(new Slider(),new Slider(),new Slider(),new Slider(),new Slider()));
        ninePatch2.contentChildren.add(new VBox(new Slider(),new Slider(),new Slider(),new Slider(),new Slider()));

        horizontalPaddingSlider1.valueProperty().addListener(observable -> {
            var i = ninePatch1.getPatchSizes();
            ninePatch1.setPatchSizes(new Insets(i.getTop(), horizontalPaddingSlider1.getValue(), i.getBottom(), horizontalPaddingSlider1.getValue()));
            ninePatch2.setPatchSizes(new Insets(i.getTop(), horizontalPaddingSlider1.getValue(), i.getBottom(), horizontalPaddingSlider1.getValue()));
        });
        horizontalPaddingSlider2.valueProperty().addListener(observable -> {
            var i = ninePatch1.getTitlePatchSizes();
            ninePatch1.setTitlePatchSizes(new Insets(i.getTop(), horizontalPaddingSlider2.getValue(), i.getBottom(), horizontalPaddingSlider2.getValue()));
            ninePatch2.setTitlePatchSizes(new Insets(i.getTop(), horizontalPaddingSlider2.getValue(), i.getBottom(), horizontalPaddingSlider2.getValue()));
        });
        verticalPaddingSlider1.valueProperty().addListener(observable -> {
            var i = ninePatch1.getPatchSizes();
            ninePatch1.setPatchSizes(new Insets(verticalPaddingSlider1.getValue(), i.getRight(), verticalPaddingSlider1.getValue(), i.getLeft()));
            ninePatch2.setPatchSizes(new Insets(verticalPaddingSlider1.getValue(), i.getRight(), verticalPaddingSlider1.getValue(), i.getLeft()));
        });
        verticalPaddingSlider2.valueProperty().addListener(observable -> {
            var i = ninePatch1.getTitlePatchSizes();
            ninePatch1.setTitlePatchSizes(new Insets(verticalPaddingSlider2.getValue(), i.getRight(), verticalPaddingSlider2.getValue(), i.getLeft()));
            ninePatch2.setTitlePatchSizes(new Insets(verticalPaddingSlider2.getValue(), i.getRight(), verticalPaddingSlider2.getValue(), i.getLeft()));
        });

        horizontalPaddingSlider3.valueProperty().addListener(observable -> {
            var i = ninePatch1.getContentPadding();
            ninePatch1.setContentPadding(new Insets(i.getTop(), horizontalPaddingSlider3.getValue(), i.getBottom(), horizontalPaddingSlider3.getValue()));
            ninePatch2.setContentPadding(new Insets(i.getTop(), horizontalPaddingSlider3.getValue(), i.getBottom(), horizontalPaddingSlider3.getValue()));
        });
        horizontalPaddingSlider4.valueProperty().addListener(observable -> {
            var i = ninePatch1.getTitlePadding();
            ninePatch1.setTitlePadding(new Insets(i.getTop(), horizontalPaddingSlider4.getValue(), i.getBottom(), horizontalPaddingSlider4.getValue()));
            ninePatch2.setTitlePadding(new Insets(i.getTop(), horizontalPaddingSlider4.getValue(), i.getBottom(), horizontalPaddingSlider4.getValue()));
        });
        verticalPaddingSlider3.valueProperty().addListener(observable -> {
            var i = ninePatch1.getContentPadding();
            ninePatch1.setContentPadding(new Insets(verticalPaddingSlider3.getValue(), i.getRight(), verticalPaddingSlider3.getValue(), i.getLeft()));
            ninePatch2.setContentPadding(new Insets(verticalPaddingSlider3.getValue(), i.getRight(), verticalPaddingSlider3.getValue(), i.getLeft()));
        });
        verticalPaddingSlider4.valueProperty().addListener(observable -> {
            var i = ninePatch1.getTitlePadding();
            ninePatch1.setTitlePadding(new Insets(verticalPaddingSlider4.getValue(), i.getRight(), verticalPaddingSlider4.getValue(), i.getLeft()));
            ninePatch2.setTitlePadding(new Insets(verticalPaddingSlider4.getValue(), i.getRight(), verticalPaddingSlider4.getValue(), i.getLeft()));
        });
        horizontalPaddingSlider5.valueProperty().addListener(observable -> {
            var i = ninePatch1.getTitleMargins();
            ninePatch1.setTitleMargins(new Insets(i.getTop(), horizontalPaddingSlider5.getValue(), i.getBottom(), horizontalPaddingSlider5.getValue()));
            ninePatch2.setTitleMargins(new Insets(i.getTop(), horizontalPaddingSlider5.getValue(), i.getBottom(), horizontalPaddingSlider5.getValue()));
        });
        verticalPaddingSlider5.valueProperty().addListener(observable -> {
            var i = ninePatch1.getTitleMargins();
            ninePatch1.setTitleMargins(new Insets(verticalPaddingSlider5.getValue(), i.getRight(), verticalPaddingSlider5.getValue(), i.getLeft()));
            ninePatch2.setTitleMargins(new Insets(verticalPaddingSlider5.getValue(), i.getRight(), verticalPaddingSlider5.getValue(), i.getLeft()));
        });


        horizontalPaddingSlider6.valueProperty().addListener(observable -> {
            var i = ninePatch1.getContentMargins();
            GridPane.setMargin(ninePatch1.patchGrid, new Insets(i.getTop(), horizontalPaddingSlider6.getValue(), i.getBottom(), horizontalPaddingSlider6.getValue()));
            GridPane.setMargin(ninePatch2.patchGrid, new Insets(i.getTop(), horizontalPaddingSlider6.getValue(), i.getBottom(), horizontalPaddingSlider6.getValue()));
        });
        verticalPaddingSlider6.valueProperty().addListener(observable -> {
            var i = ninePatch1.getContentMargins();
            GridPane.setMargin(ninePatch1.patchGrid, new Insets(verticalPaddingSlider6.getValue(), i.getRight(), verticalPaddingSlider6.getValue(), i.getLeft()));
            GridPane.setMargin(ninePatch2.patchGrid, new Insets(verticalPaddingSlider6.getValue(), i.getRight(), verticalPaddingSlider6.getValue(), i.getLeft()));
        });
    }
}
