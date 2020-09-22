package mainFolder.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class CryptFile {
	
	String password;
	
	
	
	public static void fileE(String iFile, String oFile, String Password) {
		
		try {
			FileInputStream inFile = new FileInputStream(iFile);
			FileOutputStream outFile = new FileOutputStream(oFile);

			String password = Password;
			PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
			SecretKeyFactory secretKeyFactory = SecretKeyFactory
					.getInstance("PBEWithMD5AndTripleDES");
			SecretKey secretKey = secretKeyFactory.generateSecret(pbeKeySpec);

			byte[] salt = new byte[8];
			Random random = new Random();
			random.nextBytes(salt);

			PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, 100);
			Cipher cipher = Cipher.getInstance("PBEWithMD5AndTripleDES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, pbeParameterSpec);
			outFile.write(salt);

			byte[] input = new byte[64];
			int bytesRead;
			while ((bytesRead = inFile.read(input)) != -1) {
				byte[] output = cipher.update(input, 0, bytesRead);
				if (output != null)
					outFile.write(output);
			}

			byte[] output = cipher.doFinal();
			if (output != null)
				outFile.write(output);

			inFile.close();
			outFile.flush();
			outFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: \n ");
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException: \n ");
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			System.out.println("InvalidKeySpecException: \n ");
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			System.out.println("NoSuchPaddingException: \n ");
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			System.out.println("InvalidKeyException: \n ");
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			System.out.println("InvalidAlgorithmParameterException: \n ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException: \n ");
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			System.out.println("IllegalBlockSizeException: \n ");
			e.printStackTrace();
		} catch (BadPaddingException e) {
			System.out.println("BadPaddingException: \n ");
			e.printStackTrace();
		}
		
	


	}
	
	public static void fileD(String iFile, String oFile, String Password) {
		
		try {
			
			String password = Password;
			PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
			SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndTripleDES");
			SecretKey secretKey = secretKeyFactory.generateSecret(pbeKeySpec);

			FileInputStream fis = new FileInputStream(iFile);
			byte[] salt = new byte[8];
			fis.read(salt);

			PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, 100);

			Cipher cipher = Cipher.getInstance("PBEWithMD5AndTripleDES");
			cipher.init(Cipher.DECRYPT_MODE, secretKey, pbeParameterSpec);
			FileOutputStream fos = new FileOutputStream(oFile);
			byte[] in = new byte[64];
			int read;
			while ((read = fis.read(in)) != -1) {
				byte[] output = cipher.update(in, 0, read);
				if (output != null)
					fos.write(output);
			}

			byte[] output = cipher.doFinal();
			if (output != null)
				fos.write(output);

			fis.close();
			fos.flush();
			fos.close();
			
		}catch(FileNotFoundException e) {
			System.out.println("FileNotFoundException: \n ");
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException: \n ");
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			System.out.println("InvalidKeySpecException: \n ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException: \n ");
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			System.out.println("NoSuchPaddingException: \n ");
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			System.out.println("InvalidKeyException: \n ");
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			System.out.println("InvalidAlgorithmParameterException: \n ");
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			System.out.println("IllegalBlockSizeException: \n ");
			e.printStackTrace();
		} catch (BadPaddingException e) {
			System.out.println("BadPaddingException: \n ");
			e.printStackTrace();
		}
		
		
		
	}

} //LATER Make Simple / Test
