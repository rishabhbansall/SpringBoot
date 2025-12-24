-- Fix status column type issue in PostgreSQL
-- Run this script if you encounter: "ERROR: operator does not exist: character varying >= integer"

-- First, update any numeric status values to their string equivalents
UPDATE employees
SET status =
    CASE
        WHEN status::text = '0' THEN 'INACTIVE'
        WHEN status::text = '1' THEN 'ACTIVE'
        ELSE status
    END
WHERE status::text ~ '^[0-9]+$';

-- Then, ensure the column is the correct type
ALTER TABLE employees
    ALTER COLUMN status TYPE VARCHAR(255)
    USING status::VARCHAR(255);

-- Verify the change
SELECT column_name, data_type
FROM information_schema.columns
WHERE table_name = 'employees'
  AND column_name = 'status';

-- Display updated data
SELECT id, name, email, status FROM employees;

