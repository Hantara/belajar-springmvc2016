-- tabel m_kategori --
CREATE TABLE IF NOT EXISTS m_kategori (
  kategori_id int(11) NOT NULL AUTO_INCREMENT,
  kode_kategori varchar(10) NOT NULL,
  nama_kategori varchar(255) NOT NULL,
  PRIMARY KEY (kategori_id),
  UNIQUE KEY kode_kategori (kode_kategori)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;
