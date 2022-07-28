package application;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import leonhar001.com.github.ImageHandler;
import leonhar001.com.github.consumers.IMDBConsumer;
import leonhar001.com.github.models.IMDB;

public class Controller implements Initializable {
	IMDBConsumer consumer = null;
	ImageHandler imageHandler = new ImageHandler();
	IMDB selectedMovie = null;
	String stickerText = "";
	List<IMDB> stickers = null;
	
    @FXML
    private ImageView imageViewer;
    
    @FXML
    private Button btnGenerate;
    
    @FXML
    private TextField tfText;
    
    @FXML
    private CheckBox cbRating;
    
    @FXML
    private CheckBox cbRank;
    
    @FXML
    private TableView<IMDB> table;
    
    @FXML
    private TableColumn<IMDB, String> title;

    @FXML
    private TableColumn<IMDB, Integer> year;

    @FXML
    private TableColumn<IMDB, Integer> rank;
    
    @FXML
    private TableColumn<IMDB, Double> rating;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		rating.setCellValueFactory(new PropertyValueFactory<IMDB, Double>("imDbRating"));
		title.setCellValueFactory(new PropertyValueFactory<IMDB, String>("title"));
		year.setCellValueFactory(new PropertyValueFactory<IMDB, Integer>("year"));
		rank.setCellValueFactory(new PropertyValueFactory<IMDB, Integer>("rank"));
		
		table.setItems(getInitialTableData());
		
		table.setOnMouseClicked(e -> {
			showImagePreview();
			btnGenerate.setDisable(false);
			resetInterfaceOptions();
		});
		
		btnGenerate.setOnAction(e -> {
			generateSticker();
			resetInterfaceOptions();
			
		});
		
		cbRank.setOnAction(e -> {
			controlInterfaceOptions(cbRating);
			tfText.setText( "IMDb Top "+selectedMovie.getRank()+" movie!");
		});
		
		cbRating.setOnAction(e -> {
			controlInterfaceOptions(cbRank);
			tfText.setText("IMDb Rating: "+selectedMovie.getImDbRating());
		});
		
	}

	private ObservableList<IMDB> getInitialTableData()  {
		consumer = new IMDBConsumer();
		
		try {
			stickers = consumer.consumeAPI();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return FXCollections.observableList(stickers);
	}
	
	private void showImagePreview() {
		selectedMovie = table.getSelectionModel().getSelectedItem();
		if(selectedMovie != null) {
			Image image = new Image(selectedMovie.getImage());
			imageViewer.setImage(image);
		}
	}
	
	private void generateSticker() {
		stickerText = tfText.getText();
		
		try {
			imageHandler.loadImage(selectedMovie.getImage(),
					stickerText,
					selectedMovie.getTitle(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void controlInterfaceOptions(CheckBox checkBox) {
		if(checkBox.isDisable() && tfText.isDisable()) {
			checkBox.setDisable(false);
			tfText.setDisable(false);
		}else {
			checkBox.setDisable(true);
			tfText.setDisable(true);
		}
	}
	
	private void resetInterfaceOptions() {
		tfText.setText("");
		tfText.setDisable(false);
		cbRank.setSelected(false);
		cbRank.setDisable(false);
		cbRating.setDisable(false);
		cbRating.setSelected(false);
	}
}
