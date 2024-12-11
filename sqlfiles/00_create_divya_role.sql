DO
$$
BEGIN
   IF NOT EXISTS (SELECT 1 FROM pg_roles WHERE rolname = 'divya') THEN
      CREATE ROLE divya WITH LOGIN PASSWORD 'password';
      ALTER ROLE divya CREATEDB;
   END IF;
END
$$;
