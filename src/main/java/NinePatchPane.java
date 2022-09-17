import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.css.CssMetaData;
import javafx.css.StyleableObjectProperty;
import javafx.css.StyleableProperty;
import javafx.css.converter.InsetsConverter;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class NinePatchPane extends GridPane {
    //private Logger log = LoggerFactory.getLogger(NinePatchPane.class);
    private final CssMetaData<Region, Insets> patchSizeCSS = new CssMetaData<>(
            "-fx-patch-size", InsetsConverter.getInstance(), Insets.EMPTY) {
        @Override
        public boolean isSettable(Region styleable) {
            return true;
        }

        @Override
        public StyleableProperty<Insets> getStyleableProperty(Region styleable) {
            return (StyleableProperty<Insets>) patchSizesProperty;
        }
    };

    public final ObjectProperty<Insets> patchSizesProperty = new StyleableObjectProperty<Insets>() {
        @Override public Object getBean() { return this; }
        @Override public String getName() { return "patchSizes"; }
        @Override public CssMetaData<Region, Insets> getCssMetaData() {
            return patchSizeCSS;
        }
        @Override protected void invalidated() {
        }
    };
    private final Label debugLabel;

    public final Insets getPatchSizes(){
      return patchSizesProperty.get();
    }

    public final void setPatchSizes(Insets val){
      patchSizesProperty.set(val);
    }
    public SimpleObjectProperty<Insets> contentPaddingProperty = new SimpleObjectProperty<>(new Insets(5));
    public Insets getContentPadding(){
      return contentPaddingProperty.get();
    }

    public void setContentPadding(Insets val){
      contentPaddingProperty.set(val);
    }
    public SimpleObjectProperty<Insets> titlePatchSizesProperty = new SimpleObjectProperty<>(new Insets(5));
    public Insets getTitlePatchSizes(){
        return titlePatchSizesProperty.get();
    }

    public void setTitlePatchSizes(Insets val){
        titlePatchSizesProperty.set(val);
    }
    public SimpleObjectProperty<Insets> titleMarginsProperty = new SimpleObjectProperty<>(new Insets(0));
    public Insets getTitleMargins(){
        return titleMarginsProperty.get();
    }

    public void setTitleMargins(Insets val){
        titleMarginsProperty.set(val);
    }
    public SimpleObjectProperty<Insets> titlePaddingProperty = new SimpleObjectProperty<>(new Insets(5));
    public Insets getTitlePadding(){
      return titlePaddingProperty.get();
    }

    public void setTitlePadding(Insets val){
      titlePaddingProperty.set(val);
    }

    public SimpleObjectProperty<String> titleProperty = new SimpleObjectProperty<>("Hi I'm Jody!");
    public String getTitle(){
      return titleProperty.get();
    }

    public void setTitle(String val){
      titleProperty.set(val);
    }
    public SimpleObjectProperty<HPos> titleHPosProperty = new SimpleObjectProperty<>(HPos.LEFT);
    public HPos getTitleHPos(){
      return titleHPosProperty.get();
    }

    public void setTitleHPos(HPos val){
      titleHPosProperty.set(val);
    }
    public SimpleObjectProperty<VPos> titleVPosProperty = new SimpleObjectProperty<>(VPos.BOTTOM);
    public VPos getTitleVPos(){
      return titleVPosProperty.get();
    }

    public void setTitleVPos(VPos val){
      titleVPosProperty.set(val);
    }

    public SimpleObjectProperty<Image> srcImgProperty = new SimpleObjectProperty<>(null);
    public Image getSrcImg(){
      return srcImgProperty.get();
    }

    public void setSrcImg(Image val){
      srcImgProperty.set(val);
    }
    public SimpleObjectProperty<Image> titleImgProperty = new SimpleObjectProperty<>(null);
    public Image getTitleImg(){
      return titleImgProperty.get();
    }

    public void setTitleBackground(Image val){
      titleImgProperty.set(val);
    }
    public SimpleObjectProperty<BackgroundRepeat> backgroundHRepeatProperty = new SimpleObjectProperty<>(BackgroundRepeat.NO_REPEAT);
    public BackgroundRepeat getBackgroundHRepeat(){
      return backgroundHRepeatProperty.get();
    }

    public void setBackgroundHRepeat(BackgroundRepeat val){
      backgroundHRepeatProperty.set(val);
    }
    public SimpleObjectProperty<BackgroundRepeat> backgroundVRepeatProperty = new SimpleObjectProperty<>(BackgroundRepeat.NO_REPEAT);
    public BackgroundRepeat getBackgroundVRepeat(){
      return backgroundVRepeatProperty.get();
    }

    public void setBackgroundVRepeat(BackgroundRepeat val){
      backgroundVRepeatProperty.set(val);
    }

    public SimpleObjectProperty<Boolean> titleShownProperty = new SimpleObjectProperty<>(false);
    public Boolean getTitleShown(){
        return titleShownProperty.get();
    }

    public void setTitleShown(Boolean val){
        titleShownProperty.set(val);
    }

    public SimpleObjectProperty<Border> patchBorderProperty = new SimpleObjectProperty<>(null);
    public Border getPatchBorder(){
        return patchBorderProperty.get();
    }

    public void setPatchBorder(Border val){
        patchBorderProperty.set(val);
    }

    public SimpleObjectProperty<Insets> contentMarginsProperty = new SimpleObjectProperty<>(){
        @Override
        public Insets get() {
            super.get();
            return GridPane.getMargin(patchGrid);
        }

        @Override
        public void set(Insets newValue) {
            GridPane.setMargin(patchGrid, newValue);
            super.set(newValue);
        }
    };
    public Insets getContentMargins(){
        return contentMarginsProperty.get();
    }

    public void setContentMargins(Insets val){
        contentMarginsProperty.set(val);
    }


    private Label titleText;

    GridPane patchGrid = new GridPane();

    Pane tlPane = new Pane();
    Pane tPane = new Pane();
    Pane trPane = new Pane();
    Pane rPane = new Pane();
    Pane brPane = new Pane();
    Pane bPane = new Pane();
    Pane blPane = new Pane();
    Pane lPane = new Pane();
    Pane cPane = new Pane();

    Image tl = null;
    Image t = null;
    Image tr = null;
    Image r = null;
    Image br = null;
    Image b = null;
    Image bl = null;
    Image l = null;
    Image c = null;

    GridPane contentPane = new GridPane();

    ColumnConstraints pColumn1 = new ColumnConstraints(),
            pColumn2 = new ColumnConstraints(),
            pColumn3 = new ColumnConstraints();
    RowConstraints pRow1 = new RowConstraints(),
            pRow2 = new RowConstraints(),
            pRow3 = new RowConstraints();
    private NinePatchPane titlePane = null;
    public ObservableList<Node> titleContentChildren = null;
    public ObservableList<Node> contentChildren = null;
    private boolean isTitle;

    public NinePatchPane(){
        this(false);
    }
    private NinePatchPane(boolean isTitle){

        this.isTitle = isTitle;

        patchGrid.getColumnConstraints().addAll(pColumn1, pColumn2, pColumn3);
        patchGrid.getRowConstraints().addAll(pRow1, pRow2, pRow3);

        pColumn1.setFillWidth(true);
        pColumn1.setHgrow(Priority.NEVER);
        pColumn3.setFillWidth(true);
        pColumn3.setHgrow(Priority.NEVER);

        pRow1.setFillHeight(true);
        pRow1.setVgrow(Priority.NEVER);
        pRow3.setFillHeight(true);
        pRow3.setVgrow(Priority.NEVER);

        pColumn2.setFillWidth(true);
        pColumn2.setHgrow(Priority.ALWAYS);

        pRow2.setFillHeight(true);
        pRow2.setVgrow(Priority.ALWAYS);

        contentChildren = contentPane.getChildren();
        setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));

        addAt(this, patchGrid, 0 ,0);

        patchGrid.minWidth(USE_PREF_SIZE);
        patchGrid.maxWidth(USE_PREF_SIZE);
        patchGrid.prefHeight(USE_COMPUTED_SIZE);
        patchGrid.prefWidth(USE_COMPUTED_SIZE);
        patchGrid.minHeight(USE_PREF_SIZE);
        patchGrid.maxHeight(USE_PREF_SIZE);
        contentPane.minWidth(USE_PREF_SIZE);
        contentPane.maxWidth(USE_PREF_SIZE);
        contentPane.prefHeight(USE_COMPUTED_SIZE);
        contentPane.prefWidth(USE_COMPUTED_SIZE);
        contentPane.minHeight(USE_PREF_SIZE);
        contentPane.maxHeight(USE_PREF_SIZE);

        if(getColumnConstraints().size() == 0)
            getColumnConstraints().add(new ColumnConstraints(USE_COMPUTED_SIZE, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE, Priority.ALWAYS, HPos.CENTER, true));
        else
            getColumnConstraints().set(0, new ColumnConstraints(USE_COMPUTED_SIZE, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE, Priority.ALWAYS, HPos.CENTER, true));

        if(getRowConstraints().size() == 0)
            getRowConstraints().add(new RowConstraints(USE_COMPUTED_SIZE, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE, Priority.ALWAYS, VPos.CENTER, true));
        else
            getRowConstraints().set(0, new RowConstraints(USE_COMPUTED_SIZE, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE, Priority.ALWAYS, VPos.CENTER, true));

        contentPane.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        patchGrid.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));


        patchGrid.borderProperty().bindBidirectional(patchBorderProperty);
        tlPane.borderProperty().bindBidirectional(patchBorderProperty);
        brPane.borderProperty().bindBidirectional(patchBorderProperty);

        addAt(patchGrid, tlPane, 0,0);
        addAt(patchGrid, tPane, 1,0);
        addAt(patchGrid, trPane, 2,0);
        addAt(patchGrid, rPane, 2,1);
        addAt(patchGrid, brPane, 2,2);
        addAt(patchGrid, bPane, 1,2);
        addAt(patchGrid, blPane, 0,2);
        addAt(patchGrid, lPane, 0,1);
        addAt(patchGrid, cPane, 1,1);

        addAt(patchGrid, contentPane, 0 ,0);
        GridPane.setColumnSpan(contentPane, REMAINING);
        GridPane.setRowSpan(contentPane, REMAINING);
        GridPane.setFillHeight(contentPane, true);
        GridPane.setFillWidth(contentPane, true);

        patchSizesProperty.addListener(new ChangeListener<Insets>() {
            @Override
            public void changed(ObservableValue<? extends Insets> observable, Insets oldValue, Insets newValue) {

                pRow1.setMinHeight(patchSizesProperty.get().getTop());
                pRow1.setPrefHeight(patchSizesProperty.get().getTop());
                pRow1.setMaxHeight(patchSizesProperty.get().getTop());

                pRow3.setMinHeight(patchSizesProperty.get().getBottom());
                pRow3.setPrefHeight(patchSizesProperty.get().getBottom());
                pRow3.setMaxHeight(patchSizesProperty.get().getBottom());


                pColumn1.setMinWidth(patchSizesProperty.get().getTop());
                pColumn1.setPrefWidth(patchSizesProperty.get().getTop());
                pColumn1.setMaxWidth(patchSizesProperty.get().getTop());

                pColumn3.setMinWidth(patchSizesProperty.get().getBottom());
                pColumn3.setPrefWidth(patchSizesProperty.get().getBottom());
                pColumn3.setMaxWidth(patchSizesProperty.get().getBottom());

                cutImage();
            }
        });

        contentPaddingProperty.bindBidirectional(contentPane.paddingProperty());

        backgroundHRepeatProperty.addListener(new ChangeListener<BackgroundRepeat>() {
            @Override
            public void changed(ObservableValue<? extends BackgroundRepeat> observable, BackgroundRepeat oldValue, BackgroundRepeat newValue) {
                cutImage();
            }
        });
        backgroundVRepeatProperty.addListener(new ChangeListener<BackgroundRepeat>() {
            @Override
            public void changed(ObservableValue<? extends BackgroundRepeat> observable, BackgroundRepeat oldValue, BackgroundRepeat newValue) {
                cutImage();
            }
        });

        srcImgProperty.addListener(observable -> setBackground(srcImgProperty.get()));

        contentPaddingProperty.set(new Insets(7));
        patchSizesProperty.set(new Insets(10));
        GridPane.setMargin(patchGrid, Insets.EMPTY);
        setMinSize(30, 30);

        if(!isTitle) {
            titlePane = new NinePatchPane(true);
            addAt(this, titlePane, 0,0);


            titlePane.minWidth(USE_PREF_SIZE);
            titlePane.maxWidth(USE_PREF_SIZE);
            titlePane.prefHeight(USE_COMPUTED_SIZE);
            titlePane.prefWidth(USE_COMPUTED_SIZE);
            titlePane.minHeight(USE_PREF_SIZE);
            titlePane.maxHeight(USE_PREF_SIZE);
            titlePane.patchBorderProperty.bindBidirectional(patchBorderProperty);
            GridPane.setHgrow(titlePane, Priority.NEVER);
            GridPane.setVgrow(titlePane, Priority.NEVER);
            GridPane.setFillHeight(titlePane, false);
            GridPane.setFillWidth(titlePane, false);
        }

        debugLabel = new Label();
        getChildren().add(debugLabel);
    }

    public void init() {
        if (!isTitle) {
            titlePane.contentChildren.add(titleText = new Label());
            titleText.setTextFill(Color.WHITE);
            titleText.setStyle("-fx-font-weight: bold;");
            titleText.setAlignment(Pos.CENTER);
            titleText.minWidth(USE_PREF_SIZE);
            titleText.maxWidth(USE_PREF_SIZE);
            titleText.prefHeight(USE_COMPUTED_SIZE);
            titleText.prefWidth(USE_COMPUTED_SIZE);
            titleText.minHeight(USE_PREF_SIZE);
            titleText.maxHeight(USE_PREF_SIZE);

            titleText.textProperty().bindBidirectional(titleProperty);
            titlePane.patchSizesProperty.bindBidirectional(titlePatchSizesProperty);
            titlePane.contentPaddingProperty.bindBidirectional(titlePaddingProperty);
            titlePane.visibleProperty().bindBidirectional(titleShownProperty);

            titleMarginsProperty.addListener((o, a, b) -> GridPane.setMargin(titlePane, titleMarginsProperty.get()));
            titleHPosProperty.addListener((o, a, b) -> GridPane.setHalignment(titlePane, titleHPosProperty.get()));
            titleVPosProperty.addListener((o, a, b) -> GridPane.setValignment(titlePane, titleVPosProperty.get()));
            titleImgProperty.addListener((o, a, b) -> setTitleBackground(titleImgProperty.get(), titlePane.patchSizesProperty.get()));

            GridPane.setMargin(titlePane, titleMarginsProperty.get());
            GridPane.setMargin(patchGrid, new Insets(5));

            GridPane.setHalignment(titlePane, titleHPosProperty.get());
            GridPane.setValignment(titlePane, titleVPosProperty.get());
            titleMarginsProperty.set(GridPane.getMargin(titlePane));
            titleHPosProperty.set(GridPane.getHalignment(titlePane));
            titleVPosProperty.set(GridPane.getValignment(titlePane));
            titleImgProperty.set(titlePane.getSrcImg());

            titlePaddingProperty.set(new Insets(5));
            titlePatchSizesProperty.set(new Insets(2));
        }
    }

    private void hideTitle(){
        if(titlePane==null) return;
        titleShownProperty.set(false);
    }
    private void showTitle(){
        if(titlePane==null) return;
        titleShownProperty.set(true);
    }

    private void cutImage() {
        if(srcImgProperty.get()==null) return;

        try {
            PixelReader reader = srcImgProperty.get().getPixelReader();

            Insets i = patchSizesProperty.get();
            int lWidth = (int) Math.ceil(i.getLeft());
            int rWidth = (int) Math.ceil(i.getRight());
            int tHeight = (int) Math.ceil(i.getTop());
            int bHeight = (int) Math.ceil(i.getBottom());
            //int innerH = (int)Math.ceil(getHeight()) - (int)Math.floor(i.getTop()) - (int)Math.floor(i.getBottom());
            //int innerW = (int)Math.ceil(getWidth()) - (int)Math.floor(i.getLeft()) - (int)Math.floor(i.getRight());

            int srcInnerH = (int) srcImgProperty.get().getHeight() - (int) Math.floor(i.getTop()) - (int) Math.floor(i.getBottom());
            int srcInnerW = (int) srcImgProperty.get().getWidth() - (int) Math.floor(i.getLeft()) - (int) Math.floor(i.getRight());

            pColumn1.setMinWidth(lWidth);
            pColumn1.setMaxWidth(lWidth);
            pColumn1.setPrefWidth(lWidth);

            pColumn3.setMinWidth(rWidth);
            pColumn3.setMaxWidth(rWidth);
            pColumn3.setPrefWidth(rWidth);

            pRow1.setMinHeight(tHeight);
            pRow1.setMaxHeight(tHeight);
            pRow1.setPrefHeight(tHeight);

            pRow3.setMinHeight(bHeight);
            pRow3.setMaxHeight(bHeight);
            pRow3.setPrefHeight(bHeight);

            boolean repeatsH = backgroundHRepeatProperty.get() == BackgroundRepeat.NO_REPEAT;
            boolean repeatsV = backgroundVRepeatProperty.get() == BackgroundRepeat.NO_REPEAT;
            double bgWidth = repeatsH ? 1 : BackgroundSize.AUTO;
            double bgHeight = repeatsV ? 1 : BackgroundSize.AUTO;
            BackgroundSize coverBG = new BackgroundSize(bgWidth, bgHeight, repeatsH, repeatsV, false, false);
            BackgroundSize useBG = coverBG;

            tl = new WritableImage(reader, 0, 0, lWidth, tHeight);
            tlPane.setBackground(new Background(new BackgroundImage(tl, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, useBG)));

            if(repeatsV && !repeatsH)
                useBG = new BackgroundSize(lWidth, bgHeight, false, repeatsV, false, false);
            l = new WritableImage(reader, 0, tHeight-1, lWidth, srcInnerH);
            lPane.setBackground(new Background(new BackgroundImage(l, BackgroundRepeat.NO_REPEAT, backgroundVRepeatProperty.get(), BackgroundPosition.CENTER, useBG)));
            useBG = coverBG;

            bl = new WritableImage(reader, 0, tHeight + srcInnerH-2, lWidth, bHeight);
            blPane.setBackground(new Background(new BackgroundImage(bl, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, useBG)));

            if(repeatsH && !repeatsV)
                useBG = new BackgroundSize(bgWidth, tHeight, repeatsH, false, false, false);
            t = new WritableImage(reader, lWidth-1, 0, srcInnerW, tHeight);
            tPane.setBackground(new Background(new BackgroundImage(t, backgroundHRepeatProperty.get(), BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, useBG)));
            useBG = coverBG;

            c = new WritableImage(reader, lWidth-1, tHeight-1, srcInnerW, srcInnerH);
            cPane.setBackground(new Background(new BackgroundImage(c, backgroundHRepeatProperty.get(), backgroundVRepeatProperty.get(), BackgroundPosition.CENTER, useBG)));

            if(repeatsH && !repeatsV)
                useBG = new BackgroundSize(bgWidth, bHeight, repeatsH, false, false, false);
            b = new WritableImage(reader, lWidth-1, tHeight + srcInnerH-2, srcInnerW, bHeight);
            bPane.setBackground(new Background(new BackgroundImage(b, backgroundHRepeatProperty.get(), BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, useBG)));
            useBG = coverBG;


            tr = new WritableImage(reader, lWidth + srcInnerW-2, 0, rWidth, tHeight);
            trPane.setBackground(new Background(new BackgroundImage(tr, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, useBG)));

            if(repeatsV && !repeatsH)
                useBG = new BackgroundSize(rWidth, bgHeight, false, repeatsV, false, false);
            r = new WritableImage(reader, lWidth + srcInnerW-2, tHeight-1, rWidth, srcInnerH);
            rPane.setBackground(new Background(new BackgroundImage(r, BackgroundRepeat.NO_REPEAT, backgroundVRepeatProperty.get(), BackgroundPosition.CENTER, useBG)));
            useBG = coverBG;

            br = new WritableImage(reader, lWidth + srcInnerW-2, tHeight + srcInnerH-2, rWidth, bHeight);
            brPane.setBackground(new Background(new BackgroundImage(br, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, useBG)));

            //if something seems wrong here's some code to sample pixels
//            IntBuffer ib = IntBuffer.allocate(20);
//            br.getPixelReader().getPixels(0, 0, 1, 1, WritablePixelFormat.getIntArgbInstance(), ib, 1);
//            int alpha = ((ib.get() >> 24) & 0xff);
//            int red = ((ib.get() >> 16) & 0xff);
//            int green = ((ib.get() >> 8) & 0xff);
//            int blue = ((ib.get()) & 0xff);
//            debugLabel.setText("P:" + br.getProgress() + ", W:" + br.getWidth() + ", " + alpha + ", " + red + ", " + green + ", " + blue);
        }catch (Exception ex){
            //log.error("what happened?", ex);
        }
    }

    private void addAt(GridPane gp, Node n, int columnIndex, int rowIndex){
        gp.getChildren().add(n);
        GridPane.setConstraints(n, columnIndex, rowIndex);
    }

    public void setBackground(Image img, Insets patchMargins){
        this.patchSizesProperty.set(patchMargins);
        setBackground(img);
    }
    public void setBackground(Image img){
        srcImgProperty.set(img);
        cutImage();
    }

    public void setTitleBackground(Image img, Insets titlePatchMargins){
        if(titlePane==null) return;
        titlePane.setBackground(img, titlePatchMargins);
    }

//    public ObservableList<Node> getChildrenUnmodifiable() {
//        //if(contentPane==null) return super.getChildrenUnmodifiable();
//        return contentPane.getChildrenUnmodifiable();
//    }
//    public ObservableList<Node> getChildren() {
//        //if(contentPane==null) return super.getChildren();
//        return contentPane.getChildren();
//    }

}
