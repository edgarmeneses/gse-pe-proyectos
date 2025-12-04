import sys

try:
    import PyPDF2
    print("PyPDF2 is installed")
except ImportError:
    print("PyPDF2 not installed. Installing...")
    import subprocess
    subprocess.check_call([sys.executable, "-m", "pip", "install", "PyPDF2"])
    import PyPDF2

# Open and read the PDF
pdf_path = r"c:\Users\edgar.meneses\Documents\Repos\gse-pe-proyectos\MsAdaptadorPKI\Microservicio MsAdaptadorPKI V1.0.pdf"

try:
    with open(pdf_path, 'rb') as file:
        pdf_reader = PyPDF2.PdfReader(file)
        
        print(f"Total pages: {len(pdf_reader.pages)}\n")
        print("=" * 80)
        
        # Extract text from all pages
        for page_num, page in enumerate(pdf_reader.pages, 1):
            print(f"\n--- PAGE {page_num} ---\n")
            text = page.extract_text()
            print(text)
            print("\n" + "=" * 80)
            
except Exception as e:
    print(f"Error reading PDF: {e}")
    import traceback
    traceback.print_exc()
