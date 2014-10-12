package scep;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.jscep.server.ScepServlet;
import org.jscep.transaction.TransactionId;
import org.jscep.transport.response.Capability;



public class Scep extends ScepServlet {

	protected Set<Capability> doCapabilities(String arg0) throws Exception {
		return EnumSet.of(Capability.SHA_1, Capability.SHA_256, Capability.SHA_512, Capability.POST_PKI_OPERATION);
	}

	protected List<X509Certificate> doEnrol(PKCS10CertificationRequest arg0, TransactionId arg1) throws Exception {
		return null;
	}

	protected List<X509Certificate> doGetCaCertificate(String arg0) throws Exception {
		FileInputStream inputStream = new FileInputStream("/Users/VanRyuji/Downloads/mdm/AppleIncRootCertificate.cer");
//		FileInputStream inputStream = new FileInputStream("/Users/VanRyuji/Downloads/mdm/mdm server/server.crt");
		CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
		X509Certificate certificate = (X509Certificate) certFactory.generateCertificate(inputStream);
		List<X509Certificate> certificates = new ArrayList<X509Certificate>();
		certificates.add(certificate);
		inputStream.close();
		
		return certificates;
	}

	protected List<X509Certificate> doGetCert(X500Name arg0, BigInteger arg1) throws Exception {
		return null;
	}

	protected List<X509Certificate> doGetCertInitial(X500Name arg0, X500Name arg1, TransactionId arg2) throws Exception {
		return null;
	}

	protected X509CRL doGetCrl(X500Name arg0, BigInteger arg1) throws Exception {
		return null;
	}

	protected List<X509Certificate> getNextCaCertificate(String arg0) throws Exception {
		return null;
	}

	protected X509Certificate getRecipient() {
		return null;
	}

	protected PrivateKey getRecipientKey() {
		return null;
	}

	protected X509Certificate getSigner() {
		return null;
	}

	protected PrivateKey getSignerKey() {
		return null;
	}
}
