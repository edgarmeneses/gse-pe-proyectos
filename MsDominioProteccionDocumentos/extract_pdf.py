import sys
try:
    import PyPDF2
    pdf_available = True
except ImportError:
    pdf_available = False

if not pdf_available:
    print("PyPDF2 not installed. Installing...")
    import subprocess
    subprocess.check_call([sys.executable, "-m", "pip", "install", "PyPDF2"])
    import PyPDF2

# Read the PDF file
pdf_path = r"c:\Users\edgar.meneses\Documents\Repos\ms-dominio-proteccion-documentos\MsDominioProteccionDocumentos V1.0.pdf"

with open(pdf_path, 'rb') as file:
    pdf_reader = PyPDF2.PdfReader(file)
    
    print(f"Total pages: {len(pdf_reader.pages)}")
    print("\n" + "="*80 + "\n")
    
    full_text = ""
    for page_num, page in enumerate(pdf_reader.pages, 1):
        text = page.extract_text()
        full_text += f"\n\n--- PAGE {page_num} ---\n\n{text}"
        print(f"--- PAGE {page_num} ---")
        print(text)
        print("\n")

# Also save to a text file for easier reading
with open("pdf_content.txt", "w", encoding="utf-8") as output:
    output.write(full_text)
    
print("\n" + "="*80)
print("Content saved to pdf_content.txt")
