import sys
try:
    import PyPDF2
    use_pypdf2 = True
except ImportError:
    use_pypdf2 = False

try:
    import pdfplumber
    use_pdfplumber = True
except ImportError:
    use_pdfplumber = False

pdf_path = r"c:\Users\edgar.meneses\Documents\Repos\ms-dominio-parentesco\Microservicio MsDominioParentesco V1.0.pdf"

if use_pdfplumber:
    print("=== EXTRACCIÓN CON PDFPLUMBER ===\n")
    with pdfplumber.open(pdf_path) as pdf:
        for i, page in enumerate(pdf.pages, 1):
            print(f"\n{'='*80}")
            print(f"PÁGINA {i}")
            print(f"{'='*80}\n")
            text = page.extract_text()
            if text:
                print(text)
elif use_pypdf2:
    print("=== EXTRACCIÓN CON PYPDF2 ===\n")
    with open(pdf_path, 'rb') as file:
        pdf_reader = PyPDF2.PdfReader(file)
        for i, page in enumerate(pdf_reader.pages, 1):
            print(f"\n{'='*80}")
            print(f"PÁGINA {i}")
            print(f"{'='*80}\n")
            text = page.extract_text()
            if text:
                print(text)
else:
    print("ERROR: No se encontró PyPDF2 ni pdfplumber. Instalando pdfplumber...")
    import subprocess
    subprocess.check_call([sys.executable, "-m", "pip", "install", "pdfplumber"])
    print("\nPor favor, ejecuta el script nuevamente.")
