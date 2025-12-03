import sys

try:
    import PyPDF2
    pdf_available = True
except ImportError:
    pdf_available = False
    print("PyPDF2 not available, trying pdfplumber...")

if not pdf_available:
    try:
        import pdfplumber
        pdf_available = True
    except ImportError:
        print("No PDF libraries available. Installing PyPDF2...")
        import subprocess
        subprocess.check_call([sys.executable, "-m", "pip", "install", "PyPDF2"])
        import PyPDF2

def extract_text_pypdf2(pdf_path):
    text = ""
    with open(pdf_path, 'rb') as file:
        pdf_reader = PyPDF2.PdfReader(file)
        for page_num in range(len(pdf_reader.pages)):
            page = pdf_reader.pages[page_num]
            text += f"\n--- PAGE {page_num + 1} ---\n"
            text += page.extract_text()
    return text

if __name__ == "__main__":
    pdf_path = r"c:\Users\edgar.meneses\Documents\Repos\gse-pe-proyectos\MsDatosAgendamiento\Microservicio MsDatosAgendamiento V1.0.pdf"
    
    try:
        extracted_text = extract_text_pypdf2(pdf_path)
        
        output_file = r"c:\Users\edgar.meneses\Documents\Repos\gse-pe-proyectos\MsDatosAgendamiento\PDF_EXTRACTED_CONTENT.txt"
        with open(output_file, 'w', encoding='utf-8') as f:
            f.write(extracted_text)
        
        print(f"Extraction completed. Content saved to: {output_file}")
        print(f"Total characters extracted: {len(extracted_text)}")
    except Exception as e:
        print(f"Error extracting PDF: {e}")
        sys.exit(1)
