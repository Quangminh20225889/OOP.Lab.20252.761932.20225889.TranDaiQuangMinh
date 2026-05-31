package Lab05.AimsProject.SourceCode.UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Lab05.AimsProject.SourceCode.Cart;
import Lab05.AimsProject.SourceCode.Media;
import Lab05.AimsProject.SourceCode.Playable;
import Lab05.AimsProject.SourceCode.Exception.PlayerException;

public class MediaStore extends JPanel {

    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEtchedBorder());
        setPreferredSize(new Dimension(240, 150));

        add(createMediaInfo(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
    }

    private JPanel createMediaInfo() {
        JPanel panel = new JPanel(new GridLayout(2, 1));

        JLabel title = new JLabel(media.getTitle(), SwingConstants.CENTER);
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 18));

        JLabel cost = new JLabel(media.getCost() + " $", SwingConstants.CENTER);

        panel.add(title);
        panel.add(cost);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(event -> cart.addMedia(media));
        panel.add(addToCartButton);

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(event -> playMedia());
            panel.add(playButton);
        }

        return panel;
    }

    private void playMedia() {
        try {
            ((Playable) media).play();

            JDialog dialog = new JDialog();
            dialog.setTitle("Play media");
            dialog.setModal(true);
            dialog.add(new JLabel("Playing: " + media.getTitle(), SwingConstants.CENTER));
            dialog.setSize(300, 120);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        } catch (PlayerException exception) {
            exception.printStackTrace();

            JDialog dialog = new JDialog();
            dialog.setTitle("Play error");
            dialog.setModal(true);
            dialog.add(new JLabel(exception.toString(), SwingConstants.CENTER));
            dialog.setSize(360, 120);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        }
    }
}
