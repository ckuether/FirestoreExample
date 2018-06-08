I am building an Android application using Firestore as my backend. I am writing to multiple collections within a document, and in some instances can write to a document, update the document, then delete the document all within the same WriteBatch. Whenever a user creates, then later deletes a document within the same WriteBatch my application crashes.

 Below is the link to a minimal repository where you can recreate the error, and my error log.

Steps to Reproduce
1. Click Set Document Button
2. Click Update Document Button
3. Click Delete Document Button
4. Click Commit Batch Button
5. Whala the app has crashed.
