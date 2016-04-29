package ru.apache_maven.parser;

public class Firm {
	private Info Info;
	private MainAddr mainaddr;
	private MailingAddr MailingAddr;
	private Rgstn Rgstn;
	private NoticeFiled NoticeFiled;
	private Filing Filing;
	private FormInfo FormInfo;
	
	public Info getInfo() {
		return Info;
	}
	public void setInfo(Info info) {
		Info = info;
	}
	public MainAddr getMainaddr() {
		return mainaddr;
	}
	public void setMainaddr(MainAddr mainaddr) {
		this.mainaddr = mainaddr;
	}
	public MailingAddr getMailingAddr() {
		return MailingAddr;
	}
	public void setMailingAddr(MailingAddr mailingAddr) {
		MailingAddr = mailingAddr;
	}
	public Rgstn getRgstn() {
		return Rgstn;
	}
	public void setRgstn(Rgstn rgstn) {
		Rgstn = rgstn;
	}
	public NoticeFiled getNoticeFiled() {
		return NoticeFiled;
	}
	public void setNoticeFiled(NoticeFiled noticeFiled) {
		NoticeFiled = noticeFiled;
	}
	public Filing getFiling() {
		return Filing;
	}
	public void setFiling(Filing filing) {
		Filing = filing;
	}
	public FormInfo getFormInfo() {
		return FormInfo;
	}
	public void setFormInfo(FormInfo formInfo) {
		FormInfo = formInfo;
	}
	@Override
	public String toString() {
		return "Firm [Info=" + Info + ", mainaddr=" + mainaddr + ", MailingAddr=" + MailingAddr + ", Rgstn=" + Rgstn
				+ ", NoticeFiled=" + NoticeFiled + ", Filing=" + Filing + ", FormInfo=" + FormInfo + "]";
	}
	

}
