/*
 * The MIT License
 *
 * Copyright 2016 Lutana.de
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package de.lutana.easyflickrbackup;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.people.PeopleInterface;
import com.flickr4java.flickr.people.User;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.PhotosInterface;
import com.flickr4java.flickr.photos.Size;
import com.flickr4java.flickr.util.FileAuthStore;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.scribe.model.Token;
import org.scribe.model.Verifier;

public class GUI extends javax.swing.JFrame implements Runnable {

	public GUI() throws FlickrException {
		isRunning = false;
		sizes = new ImageSizes();
		flickr = new Flickr(FlickrConfig.API_KEY, FlickrConfig.SECRET_KEY, new REST());
		flickrAuth = new FileAuthStore(Settings.getAuthDirectory());

		initComponents();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		updateComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT
	 * modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        settingsPanel = new javax.swing.JPanel();
        dirLabel = new javax.swing.JLabel();
        dirField = new javax.swing.JTextField();
        dirBtn = new javax.swing.JButton();
        authLabel = new javax.swing.JLabel();
        authBtn = new javax.swing.JButton();
        userBox = new javax.swing.JComboBox();
        sizeLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sizeBox = new javax.swing.JList();
        backupPanel = new javax.swing.JPanel();
        startBtn = new javax.swing.JButton();
        backupSep = new javax.swing.JSeparator();
        statusLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        cancelBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        openFolderBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        aboutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EasyFlickrBackup");

        settingsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("1. Prepare backup"));

        dirLabel.setText("Backup folder:");

        dirField.setEditable(false);

        dirBtn.setText("Choose...");
        dirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dirBtnActionPerformed(evt);
            }
        });

        authLabel.setText("User account:");

        authBtn.setText("Authenticate another user");
        authBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authBtnActionPerformed(evt);
            }
        });

        Auth[] auths = this.flickrAuth.retrieveAll();
        for (Auth auth : auths) {
            userBox.addItem(new StringContainer.Auth(auth));
        }
        if (userBox.getItemCount() > 0) {
            userBox.setSelectedIndex(0);
            updateAuth();
        }
        userBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userBoxActionPerformed(evt);
            }
        });

        sizeLabel.setText("Image Size(s):");

        DefaultListModel model = new DefaultListModel();
        Iterator<Entry<Integer, String>> it = sizes.getAllNames().iterator();
        while (it.hasNext()) {
            model.addElement(new StringContainer.Entry(it.next()));
        }
        sizeBox.setModel(model);
        sizeBox.setSelectedIndices(Settings.getSelectedSizes(sizes.getAllNames().size()-1));
        sizeBox.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                sizeBoxValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(sizeBox);

        javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addComponent(dirLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(settingsPanelLayout.createSequentialGroup()
                                .addComponent(dirField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dirBtn))
                            .addGroup(settingsPanelLayout.createSequentialGroup()
                                .addComponent(userBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(authBtn))))
                    .addComponent(authLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addComponent(sizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)))
                .addContainerGap())
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dirLabel)
                    .addComponent(dirField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dirBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(authLabel)
                    .addComponent(authBtn)
                    .addComponent(userBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sizeLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap())
        );

        backupPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("2. Execute backup"));

        startBtn.setText("Start backup");
        startBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBtnActionPerformed(evt);
            }
        });

        statusLabel.setText("Backup hasn't started yet!");

        cancelBtn.setText("Stop");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backupPanelLayout = new javax.swing.GroupLayout(backupPanel);
        backupPanel.setLayout(backupPanelLayout);
        backupPanelLayout.setHorizontalGroup(
            backupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(startBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backupSep)
                    .addGroup(backupPanelLayout.createSequentialGroup()
                        .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelBtn))
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        backupPanelLayout.setVerticalGroup(
            backupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(startBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backupSep, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusLabel)
                    .addComponent(cancelBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("3. Finish backup"));
        jPanel1.setToolTipText("");

        openFolderBtn.setText("Open backup folder");
        openFolderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFolderBtnActionPerformed(evt);
            }
        });

        jButton1.setText("Quit program");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        aboutBtn.setText("About the program");
        aboutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(openFolderBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(aboutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(openFolderBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(aboutBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(settingsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(settingsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void updateComponents() {
		File dir = Settings.getBackupDirectory();
		boolean sizesSelected = (sizeBox.getSelectedIndices().length > 0);
		dirField.setText(dir.getAbsolutePath());
		startBtn.setEnabled(dir.exists() && this.isAuthenticated() && !this.isRunning() && sizesSelected);
		openFolderBtn.setEnabled(dir.exists() && this.isAuthenticated());
		cancelBtn.setEnabled(this.isRunning());
		progressBar.setEnabled(this.isRunning());
	}

	public void updateAuth() {
		StringContainer.Auth authContainer = (StringContainer.Auth) userBox.getSelectedItem();
		if (authContainer != null) {
			this.setAuth(authContainer.get());
		}
	}

	private boolean isAuthenticated() {
		return (this.getAuth() != null);
	}

	private Auth getAuth() {
		return flickr.getAuth();
	}

	private void setAuth(Auth auth) {
		flickr.setAuth(auth);
	}

	private boolean isRunning() {
		return isRunning;
	}
	
	private String generateFilename(Photo p, int size) {
		String suffix = sizes.getSuffix(size);
		if (size == Size.ORIGINAL) {
			return p.getId() + "_" + p.getOriginalSecret() + suffix + "." + p.getOriginalFormat();
		}
		else {
			return p.getId() + "_" + p.getSecret() + suffix + ".jpg";
		}
	}

	public File getBackupDirectory() {
		User user = this.getAuth().getUser();
		File basedir = Settings.getBackupDirectory();
		String dir = basedir.getAbsolutePath();
		dir += File.separator;
		dir += user.getId();
		File file = new File(dir);
		if (!file.exists()) {
			file.mkdirs();
		}
		if (!file.exists()) {
			file = basedir;
		}
		return file;
	}
	
	public Collection<Integer> getSelectedSizes() {
		Collection<Integer> list = new ArrayList<>();
		Iterator<StringContainer.Entry> it = sizeBox.getSelectedValuesList().iterator();
		while (it.hasNext()) {
			StringContainer.Entry entryContainer = it.next();
			if (entryContainer != null) {
				Entry<Integer,String> entry = entryContainer.get();
				if (entry != null && entry.getKey() != null) {
					list.add(entry.getKey());
				}
			}
		}
		return list;
	}
	
	public Collection<Integer> getSizes(Collection<Size> available, Collection<Integer> selected) {
		Collection<Integer> list = new ArrayList<>();
        for (Size size : available) {
            if(selected.contains(size.getLabel())) {
                list.add(size.getLabel());
            }
        }
		return list;
	}

    private void authBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authBtnActionPerformed
		AuthInterface authInterface = flickr.getAuthInterface();
		Token accessToken = authInterface.getRequestToken();

		JOptionPane.showMessageDialog(this, "You are redirected to the Flickr authentication process now.\r\nAfterwards you need to enter the authentication token here.");
		String urlString = authInterface.getAuthorizationUrl(accessToken, Permission.READ);
		try {
			Desktop.getDesktop().browse(new URI(urlString));
		} catch (Exception ex) {
			JOptionPane.showInputDialog(this, "Can't open the browser.\r\nPlease visit the following web page:", urlString);
		}
		String tokenKey = JOptionPane.showInputDialog(this, "Please enter the authentication token:");
		if (tokenKey == null || tokenKey.isEmpty()) {
			return;
		}
		try {
			Token requestToken = authInterface.getAccessToken(accessToken, new Verifier(tokenKey));
			Auth auth = authInterface.checkToken(requestToken);
			StringContainer.Auth ac = new StringContainer.Auth(auth);
			userBox.addItem(ac);
			userBox.setSelectedItem(ac);
			updateAuth();
			flickrAuth.store(auth);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
		updateComponents();
    }//GEN-LAST:event_authBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void openFolderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFolderBtnActionPerformed
		try {
			Desktop.getDesktop().open(this.getBackupDirectory());
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, "Can't open the backup folder.");
		}
    }//GEN-LAST:event_openFolderBtnActionPerformed

    private void dirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dirBtnActionPerformed
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(Settings.getBackupDirectory());
		fc.setDialogTitle("Verzeichnis wählen...");
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fc.setAcceptAllFileFilterUsed(false);
		if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File dir = fc.getSelectedFile();
			Settings.setBackupDirectory(dir);
			updateComponents();
		}
    }//GEN-LAST:event_dirBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
		isRunning = false;
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBtnActionPerformed
		isRunning = true;
		updateComponents();
		Thread t = new Thread(this);
		t.start();
    }//GEN-LAST:event_startBtnActionPerformed

    private void userBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userBoxActionPerformed
		updateAuth();
		updateComponents();
    }//GEN-LAST:event_userBoxActionPerformed

    private void aboutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutBtnActionPerformed
		AboutDlg dlg = new AboutDlg(this);
		dlg.setVisible(true);
    }//GEN-LAST:event_aboutBtnActionPerformed

    private void sizeBoxValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_sizeBoxValueChanged
		Settings.setSelectedSizes(sizeBox.getSelectedIndices());
		updateComponents();
    }//GEN-LAST:event_sizeBoxValueChanged
	
	@Override
	public void run() {
		this.statusLabel.setText("Initializing download process...");
		progressBar.setValue(0);
		File directory = this.getBackupDirectory();
		if (!directory.mkdirs()) {
			
		}
		PeopleInterface peopleInt = flickr.getPeopleInterface();
		PhotosInterface photoInt = flickr.getPhotosInterface();
		int pages = 1;
		int page = 1;
		int total = 0;
		int current = 0;
		int error = 0;
		Collection<Integer> selectedSizes = this.getSelectedSizes();
		Set<String> options = new HashSet<>();
		options.add("original_format");
		try {
			do {
				RequestContext.getRequestContext().setAuth(this.getAuth());
				PhotoList<Photo> list = peopleInt.getPhotos("me", null, null, null, null, null, null, null, options, 500, page);
				if (page == 1) {
					pages = list.getPages();
					total = list.getTotal();
					progressBar.setMinimum(0);
					progressBar.setMaximum(total);
					progressBar.setValue(0);
				}
				Iterator<Photo> it = list.iterator();
				while (it.hasNext() && isRunning) {
					current++;
					Photo p = it.next();
					String status = "Photo " + current + " of " + total + ": ";
					this.statusLabel.setText(status + "Checking for new images");
					Collection<Integer> sizes = this.getSizes(photoInt.getSizes(p.getId(), true), selectedSizes);
					int sizeCount = 0;
					Iterator<Integer> itSize = sizes.iterator();
					while (itSize.hasNext() && isRunning) {
						Integer size = itSize.next();
						sizeCount++;
						this.statusLabel.setText(status + "Downloading size " + sizeCount + " of " + sizes.size());
						try {
							File newFile = new File(directory, this.generateFilename(p, size));
							if (!newFile.exists()) {
								BufferedInputStream bis = new BufferedInputStream(photoInt.getImageAsStream(p, size));
								FileOutputStream fos = new FileOutputStream(newFile);
								int read;
								byte[] buffer = new byte[100 * 1024];
								while ((read = bis.read(buffer)) != -1) {
									fos.write(buffer, 0, read);
								}
								fos.flush();
								fos.close();
								bis.close();
							}
						} catch (Exception e) {
							error++;
						}
					}
					progressBar.setValue(current);
				}
				page++;
			} while (page <= pages && isRunning);
			statusLabel.setText(isRunning ? "Download of " + total + " photos finished. " + (error == 0 ? "No" : error) + " errors occured!" : "Stopped downloading process. You can resume it at any time.");
		} catch (FlickrException ex) {
			statusLabel.setText(ex.getMessage());
		}
		isRunning = false;
		updateComponents();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					GUI g = new GUI();
					g.setVisible(true);
				} catch (FlickrException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
	}

	private final ImageSizes sizes;
	private boolean isRunning;
	private final FileAuthStore flickrAuth;
	private final Flickr flickr;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutBtn;
    private javax.swing.JButton authBtn;
    private javax.swing.JLabel authLabel;
    private javax.swing.JPanel backupPanel;
    private javax.swing.JSeparator backupSep;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton dirBtn;
    private javax.swing.JTextField dirField;
    private javax.swing.JLabel dirLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton openFolderBtn;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JList sizeBox;
    private javax.swing.JLabel sizeLabel;
    private javax.swing.JButton startBtn;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JComboBox userBox;
    // End of variables declaration//GEN-END:variables

}
