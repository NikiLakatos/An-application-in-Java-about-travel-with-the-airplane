import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class Interfata {


		private static JLabel info = new JLabel("");
		private static CompaniiAeriene companiiAeriene = new CompaniiAeriene();

		public static void addButton(JFrame frame) {
			JButton adaugare = new JButton("Adaugare");
			JButton stergere = new JButton("Stergere");
			JButton cautare = new JButton("Cautare");
			JButton iesire = new JButton("Iesire");
			JComboBox<String> lista = new JComboBox<String>();
			JButton afisare = new JButton("Afisare");

			afisare.setBounds(400, 0, 100, 30);
			adaugare.setBounds(400, 40, 100, 30);
			stergere.setBounds(400, 80, 100, 30);
			cautare.setBounds(400, 120, 100, 30);
			iesire.setBounds(400, 160, 100, 30);
			lista.setBounds(0, 0, 400, 30);

			frame.add(afisare);
			frame.add(adaugare);
			frame.add(stergere);
			frame.add(cautare);
			frame.add(iesire);
			frame.add(lista);

			for (Map.Entry<String, CompaniiAeriene> entry : companiiAeriene.getCompanii().entrySet()) {
				lista.addItem(entry.getKey());

			}

			afisare.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					String numeCompanie = lista.getSelectedItem().toString();
					JFrame detalii = new JFrame("Detalii");
					JButton inapoi = new JButton("Back");

					if (numeCompanie.equals("Lufthansa"))
						background(detalii, "src\\imagini\\img.jpg");
					else if (numeCompanie.equals("Tarom"))
						background(detalii, "src\\imagini\\tarom.jpg");
					else if (numeCompanie.equals("Wizz Air"))
						background(detalii, "src\\imagini\\wizzair.jpg");
					else if (numeCompanie.equals("KLM"))
						background(detalii, "src\\imagini\\klm.jpg");
					else if (numeCompanie.equals("Ryanair"))
						background(detalii, ("src\\imagini\\ryanair.jpg"));
					else if (numeCompanie.equals("Austrian"))
						background(detalii, ("src\\imagini\\austrian.jpg"));
					else {
						background(detalii, ("src\\imagini\\inplus.jpg"));
					}

					inapoi.setBounds(500, 300, 100, 30);
					info.setBounds(25, 30, 150, 160);
					info.setFont(new Font("alex", Font.BOLD, 20));

					detalii.add(info);
					detalii.add(inapoi);
					frame.setVisible(false);
					detalii.setLocation(300, 60);
					detalii.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

					detalii.pack();
					detalii.setResizable(true);
					for (Map.Entry<String, CompaniiAeriene> entry : companiiAeriene.getCompanii().entrySet()) {
						if (entry.getKey().equals(numeCompanie)) {

							info.setText("Informatii:");
							info = new JLabel(entry.getValue().toString());
							info.setFont(new Font("alex", Font.ITALIC, 20));
							detalii.add(info);
							info.setBounds(10, 10, 600, 450);

							detalii.setVisible(true);
							inapoi.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									
									detalii.setVisible(false);
									frame.setVisible(true);
									
								}

							});
							break;	
						}
						
					}
				}

			});

			adaugare.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					String numeCompanie = JOptionPane.showInputDialog("Introduceti numele Companie");

					while (numeCompanie == null || numeCompanie.equals("")) {
						numeCompanie = JOptionPane.showInputDialog("Introduceti numele Companie");
					}

					String nrPasageri = JOptionPane.showInputDialog("Introduceti numarul de pasageri");

					while ( nrPasageri == null || nrPasageri.equals("") || !nrPasageri.matches("[0-9]+"))

					{
						nrPasageri = JOptionPane.showInputDialog("Introduceti numar pasageri ");
					}

					String pretBilete = JOptionPane.showInputDialog("Introduceti pretul Biletului");

					while (pretBilete == null || pretBilete.equals("") || !pretBilete.matches("[0-9]+"))

					{
						pretBilete = JOptionPane.showInputDialog("Introduceti pretul biletului");
					}

					String plecare = JOptionPane.showInputDialog("Introducti locul de unde plecati");

					while ( plecare == null || plecare.equals("")) {
						plecare = JOptionPane.showInputDialog("Introduceti locul de unde plecati");
					}
					String sosire = JOptionPane.showInputDialog("Introducti locul sosiri");
					while ( sosire == null || sosire.equals("") ) {
						sosire = JOptionPane.showInputDialog("Introduceti locul sosiri");
					}
					String data = JOptionPane.showInputDialog("Introduceti data plecarii");
					while ( data == null || data.equals("")) {
						data = JOptionPane.showInputDialog("Introduceti data plecarii");
					}
					String ora = JOptionPane.showInputDialog("La ce ora plecati");
					while (ora == null || ora.equals("")) {

						ora = JOptionPane.showInputDialog("La ce ora plecati");
					}
					String ora1 = JOptionPane.showInputDialog("La ce ora sositi");
					while ( ora1 == null || ora.equals("")) {
						ora1 = JOptionPane.showInputDialog("La ce ora sositi");
					}
					String locuriDisponibil = JOptionPane.showInputDialog("Introduceti locuri disponiblile");

					while (locuriDisponibil.equals("") || locuriDisponibil == null || !locuriDisponibil.matches("[0-9]+"))

				
					{
						locuriDisponibil = JOptionPane.showInputDialog("Introduceti locuri disponibile");
					}

					lista.addItem(numeCompanie);
					CompaniiAeriene companiiAeriene = new CompaniiAeriene();
					companiiAeriene.add(
							new CompaniiAeriene(numeCompanie, Integer.parseInt(nrPasageri), Integer.parseInt(pretBilete),
									plecare, sosire, data, ora, ora1, Integer.parseInt(locuriDisponibil)));
				}
			});

			stergere.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					for (Map.Entry<String, CompaniiAeriene> entry : companiiAeriene.getCompanii().entrySet()) {
						if (entry.getKey().toUpperCase().equals(lista.getSelectedItem().toString().toUpperCase())) {
							companiiAeriene.remove(lista.getSelectedItem().toString());
							lista.removeItem(lista.getSelectedItem());
							break;
						}
						
					}

				}

			});

			cautare.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {

					String numeCautat = JOptionPane.showInputDialog("Numele cautat este");
					while ( numeCautat.equals("") || numeCautat == null )
						numeCautat = JOptionPane.showInputDialog("Numele cautat a fost gasit");
					for (Map.Entry<String, CompaniiAeriene> entry : companiiAeriene.getCompanii().entrySet()) {
						if (entry.getKey().toUpperCase().equals(numeCautat.toUpperCase())) {
							JFrame gasit = new JFrame();
							JLabel mesaj = new JLabel();
							mesaj.setText("Obiectul a fost gasit");
							mesaj.setBounds(10, 0, 70, 40);
							gasit.setSize(300, 70);
							gasit.setLocation(400, 350);
							gasit.setResizable(false);
							gasit.add(mesaj);
							gasit.setVisible(true);

						}

					}

				}

			});

			iesire.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					frame.dispose();
					System.exit(0);

				}

			});

		}

		public static void interfata() {
			JFrame mare = new JFrame("Companii Aeriene");
			mare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mare.setLayout(null);
			background(mare, "src\\imagini\\start.jpg");
			addButton(mare);
			mare.setLocation(350, 100);
			mare.setResizable(false);
			mare.setVisible(true);
			mare.pack();

		}

		public static void background(JFrame frame, String img) {
			try {
				frame.setContentPane(new JLabel((Icon) new ImageIcon(ImageIO.read(new File(img)))));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
}
