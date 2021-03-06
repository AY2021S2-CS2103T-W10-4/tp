package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import seedu.address.model.person.Person;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";
    private static final Background vaccinatedBg = new Background(new BackgroundFill(Color.web("#0277BD"),
            new CornerRadii(5.0), new Insets(-5.0)));
    private static final Background notVaccinatedBg = new Background(new BackgroundFill(Color.web("#DD2C00"),
            new CornerRadii(5.0), new Insets(-5.0)));

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Person person;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label vaccinationStatus;
    @FXML
    private Label id;
    @FXML
    private Label matriculationNumber;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label email;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public PersonCard(Person person, int displayedIndex) {
        super(FXML);
        this.person = person;
        id.setText(displayedIndex + ". ");
        name.setText(person.getName().fullName);
        matriculationNumber.setText(person.getMatriculationNumber().value);
        phone.setText("Mobile Number: " + person.getPhone().value);
        address.setText("Address: " + person.getAddress().value);
        vaccinationStatus.setText(person.getVaccinationStatus().value);
        vaccinationStatus.setBackground(person.getVaccinationStatus().value.equals("vaccinated") ? vaccinatedBg
                : notVaccinatedBg);
        email.setText("Email: " + person.getEmail().value);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PersonCard)) {
            return false;
        }

        // state check
        PersonCard card = (PersonCard) other;
        return id.getText().equals(card.id.getText())
                && person.equals(card.person);
    }
}
