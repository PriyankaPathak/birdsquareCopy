mysql -uroot < "database/create_schema.sql"
mysql -uroot --local-infile < "database/populate_data.sql"