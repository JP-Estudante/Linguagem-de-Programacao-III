package mercadofx;

import java.sql.Connection;

import DAO.ClienteDAO;
import Models.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class SecondaryController {
    private Stage secondaryStage;
    private ClienteDAO clienteDAO;
    private Connection connection;

    private boolean f1KeyPressed = false;

    public void setSecondaryStage(Stage stage) {
        this.secondaryStage = stage;
    }

    @FXML
    private TextField cpfTextField;

    @FXML
    private TextField idTextField = null;

    @FXML
    private TextField nomeTextField = null;

    @FXML
    private Button cancelarButton;

    @FXML
    private Button continuarButton;

    @FXML
    public void initialize(Connection connection) {
        this.connection = connection;
        this.clienteDAO = new ClienteDAO(connection);

        // Formatar cpfTextField
        cpfTextField.addEventFilter(KeyEvent.KEY_TYPED, this::formatarCPF);

        // Adicionar um ou dois zeros à esquerda no idTextField
        idTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                int id = Integer.parseInt(newValue);
                String formattedId = formatId(id);
                idTextField.setText(formattedId);
            }
        });
    }

    @FXML
    private void formatarCPF(KeyEvent event) {
        // Obtém o texto atual do TextField
        String textoAtual = cpfTextField.getText();

        // Obtém a posição do cursor
        int posicaoCursor = cpfTextField.getCaretPosition();

        // Se a tecla pressionada for o backspace e o texto não estiver vazio
        if (event.getCharacter().isEmpty() && !textoAtual.isEmpty()) {
            // Remove o último caractere do texto atual
            textoAtual = textoAtual.substring(0, textoAtual.length() - 1);
        }

        // Remove caracteres não numéricos
        String textoNumerico = textoAtual.replaceAll("[^\\d]", "");

        // Limita o tamanho do texto a 11 caracteres
        if (textoNumerico.length() > 11) {
            textoNumerico = textoNumerico.substring(0, 11);
        }

        // Formata o CPF
        StringBuilder cpfFormatado = new StringBuilder();
        for (int i = 0; i < textoNumerico.length(); i++) {
            cpfFormatado.append(textoNumerico.charAt(i));
            if (i == 2 || i == 5) {
                cpfFormatado.append(".");
            } else if (i == 8) {
                cpfFormatado.append("-");
            }
        }

        // Define o texto formatado no TextField
        cpfTextField.setText(cpfFormatado.toString());

        // Calcula a nova posição do cursor
        int novaPosicaoCursor = posicaoCursor + (cpfFormatado.length() - textoAtual.length());

        // Define a posição do cursor após a formatação
        cpfTextField.positionCaret(novaPosicaoCursor);

        // Consume o evento apenas se o texto formatado não for igual ao texto atual
        if (!cpfFormatado.toString().equals(textoAtual)) {
            event.consume();
        }
    }

    @FXML
    void buscarClienteCPF(ActionEvent event) {
        if (!cpfTextField.getText().isEmpty()) {
            String cpfString = cpfTextField.getText().replaceAll("[^0-9]", "");
            if (!cpfString.isEmpty()) {
                String cpf = cpfString;
                Cliente cliente = clienteDAO.getClienteByCpf(cpf);

                if (cliente != null) {
                    nomeTextField.setText(cliente.getNome());
                    idTextField.setText(String.valueOf(cliente.getId()));

                    continuarButton.setDisable(false);

                } else {
                    nomeTextField.setText("Cliente não encontrado");
                }
            } else {
                // Tratar o caso em que a string está vazia após a remoção de caracteres não
                // numéricos
            }

            // Consumir o evento apenas se o cliente for encontrado
            event.consume();
        } else if (!idTextField.getText().isEmpty()) {
            int id = Integer.parseInt(idTextField.getText());
            Cliente cliente = clienteDAO.getClienteById(id);

            if (cliente != null) {
                nomeTextField.setText(cliente.getNome());
            } else {
                nomeTextField.setText("Cliente não encontrado");
            }

            // Consumir o evento apenas se o cliente for encontrado
            event.consume();
        }
    }

    @FXML // Manipular eventos de teclado (Esc e F1)
    void keyBindsReleased(KeyEvent event) {
        if (secondaryStage != null) {
            if (event.getCode() == KeyCode.ESCAPE) {
                // Ação para a tecla Esc
                handleCancelAction();
            } else if (event.getCode() == KeyCode.F1 && event.getEventType() == KeyEvent.KEY_RELEASED
                    && !f1KeyPressed) {
                // Ação para a tecla F1
                handleContinueAction();
            }
        }
    }

    @FXML // Método para lidar com eventos de tecla pressionada
    void keyBindsPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.F1) {
            // Marcar que a tecla F1 foi liberada
            f1KeyPressed = false;
        }
    }

    @FXML // Evento com o botão cancelar
    void handleCancelarButton(ActionEvent event) {
        System.out.println("Venda sem cliente!");
        closeWindow();
    }

    @FXML // Evento com o botão continuar
    void handleContinueButton(ActionEvent event) {
        System.out.println("Venda com cliente!");
        closeWindow();
    }

    private void handleCancelAction() {
        System.out.println("Venda sem cliente!");
        closeWindow();
    }

    private void handleContinueAction() {
        if (!idTextField.getText().isEmpty() && !nomeTextField.getText().isEmpty()
                && cpfTextField.getText().replaceAll("[^0-9]", "").length() == 11) {
            // Se houver um cliente
            System.out.println("Venda com cliente!");
            System.out.println(cpfTextField.getText());
            
            // Marcar que a tecla F1 foi pressionada
            f1KeyPressed = true;

            closeWindow();
        } else {
            System.out.println("Não é possível continuar sem um cliente!");
        }
    }

    private String formatId(int id) {
        String idStr = String.valueOf(id);
        if (idStr.length() == 1) {
            return "00" + idStr;
        } else if (idStr.length() == 2) {
            return "0" + idStr;
        }
        return idStr;
    }

    private void closeWindow() {
        if (secondaryStage != null) {
            secondaryStage.close();
        }
    }
}
